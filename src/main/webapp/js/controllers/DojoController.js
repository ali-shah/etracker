var map;
require([
    "dojo",
    "dojo/dom",
    "dojo/on",
    "dojo/keys"
], function (dojo, dom, on, keys) {

    var goButton = dom.byId("goButton");
    on(goButton, "click", function (evt) {
        process();
    });
    var rego = dom.byId("rego");
    on(rego, "keyup", function (event) {
        switch (event.keyCode) {
            case keys.ENTER:
                process();
                break;
        }
    });
    var markers = [];
    function initialize() {
        var centerPoint = new google.maps.LatLng(-36.848564, 174.765308);
        var mapOptions = {
            zoom: 15,
            center: centerPoint,
            mapTypeId: google.maps.MapTypeId.TERRAIN
        };
        map = new google.maps.Map(document.getElementById('mymap'), mapOptions);
    }
    function deleteMarkers() {
        clearMarkers();
        markers = [];
    }
    function clearMarkers() {
        setAllMap(null);
    }
// Sets the map on all markers in the array.
    function setAllMap(map) {
        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(map);
        }
    }

    function process() {
        var args = {
            url: "http://localhost:8080/etracker/webapi/vehicles/" + dom.byId("rego").value,
            handleAs: "json",
            preventCache: true
        };
        // Call the asynchronous xhrGet
        var deferred = dojo.xhrGet(args);

        // Now add the callbacks
        deferred.then(
                function (data) {
                    if (typeof map === 'undefined') {
                        initialize();
                    }
                    if (data === null || typeof data.city === 'undefined') {
                        $('#myModal').modal('show');
                        map.setCenter(new google.maps.LatLng(-36.848564, 174.765308));
                    } else {
                        createMarker(data);
                        map.panTo(new google.maps.LatLng(data.latitude, data.langitude));
                        map.setZoom(15);
                    }
                },
                function (error) {
                    //do something if error occurs
                }
        );

        var infoWindow = new google.maps.InfoWindow();
        var createMarker = function (info) {
            deleteMarkers();
            var image = 'images/marker3.png';
            var marker = new google.maps.Marker({
                map: this.map,
                position: new google.maps.LatLng(info.latitude, info.langitude),
                title: info.city,
                icon: image
            });
            marker.content = '<div class="infoWindowContent"> <b>Registration</b>: ' + info.vehicleRego + '<br><b>Driver Name</b>: ' + info.driverName + '</div>';

            google.maps.event.addListener(marker, 'click', function () {
                infoWindow.setContent('<h3 style="color:gray">' + marker.title + '</h3>' + marker.content);
                infoWindow.open(map, marker);
            });

            markers.push(marker);
        };
        var openInfoWindow = function (e, selectedMarker) {
            e.preventDefault();
            google.maps.event.trigger(selectedMarker, 'click');
        };
    };


});

