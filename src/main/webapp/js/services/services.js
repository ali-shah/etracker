app.factory("Vehicle", function($resource) {
  return $resource("http://localhost:8080/etracker/webapi/vehicles/:vehicleRego");
});