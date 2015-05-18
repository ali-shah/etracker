app.controller('MainController', function ($scope, Vehicle) {
    $scope.process = function () {
        //alert("Hellow world " + $scope.rego);
        Vehicle.get({vehicleRego: $scope.rego}, function (data) {
            $scope.vehicle = data;
            createMarker(data);
        });


        var mapOptions = {
            zoom: 15,
//            center: new google.maps.LatLng(-36.848564, 174.765308),
//            center: new google.maps.LatLng($scope.vehicle.latitude, $scope.vehicle.langitude),
            mapTypeId: google.maps.MapTypeId.TERRAIN
        }

        $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);
        $scope.map.setCenter(new google.maps.LatLng(-36.848564, 174.765308));
//        $scope.map.panTo(new google.maps.LatLng(-36.848564, 174.765308));
//        $scope.map.panBy(100,100);
        $scope.markers = [];

        var infoWindow = new google.maps.InfoWindow();

        var createMarker = function (info) {
            var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
            var image = 'images/marker3.png';
            var marker = new google.maps.Marker({
                map: $scope.map,
                position: new google.maps.LatLng(info.latitude, info.langitude),
                title: info.city,
                icon: image /*iconBase + 'schools_maps.png'*/
            });
            marker.content = '<div class="infoWindowContent"> <b>Registration</b>: ' + info.vehicleRego + '<br><b>Driver Name</b>: ' + info.driverName + '</div>';

            google.maps.event.addListener(marker, 'click', function () {
                infoWindow.setContent('<h3 style="color:gray">' + marker.title + '</h3>' + marker.content);
                infoWindow.open($scope.map, marker);
            });

            $scope.markers.push(marker);

        }

        $scope.openInfoWindow = function (e, selectedMarker) {
            e.preventDefault();
            google.maps.event.trigger(selectedMarker, 'click');
        }

    };
});