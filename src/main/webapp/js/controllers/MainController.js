app.controller('MainController', function ($scope, Vehicle) {
    $scope.map;
    var markers = [];
    function initialize() {
        var centerPoint = new google.maps.LatLng(-36.848564, 174.765308);
        var mapOptions = {
            zoom: 15,
            center: centerPoint,
            mapTypeId: google.maps.MapTypeId.TERRAIN
        };
        $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
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

    $scope.process = function () {
        var data = Vehicle.get({vehicleRego: $scope.rego}, function () {
            $scope.vehicle = data;
            if (typeof $scope.map === 'undefined') {
                initialize();
            }
            if (typeof data.city === 'undefined') {
                $('#myModal').modal('show');
                $scope.map.setCenter(new google.maps.LatLng(-36.848564, 174.765308));
            } else {
                createMarker(data);
                $scope.map.panTo(new google.maps.LatLng(data.latitude, data.langitude));
                $scope.map.setZoom(15);
            }
        });
        var infoWindow = new google.maps.InfoWindow();
        var createMarker = function (info) {
            deleteMarkers();
            var image = 'images/marker3.png';
            var marker = new google.maps.Marker({
                map: $scope.map,
                position: new google.maps.LatLng(info.latitude, info.langitude),
                title: info.city,
                icon: image
            });
            marker.content = '<div class="infoWindowContent"> <b>Registration</b>: ' + info.vehicleRego + '<br><b>Driver Name</b>: ' + info.driverName + '</div>';

            google.maps.event.addListener(marker, 'click', function () {
                infoWindow.setContent('<h3 style="color:gray">' + marker.title + '</h3>' + marker.content);
                infoWindow.open($scope.map, marker);
            });

            markers.push(marker);
        }
        $scope.openInfoWindow = function (e, selectedMarker) {
            e.preventDefault();
            google.maps.event.trigger(selectedMarker, 'click');
        }
    };
});