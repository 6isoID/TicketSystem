//= require controllers/CommonControllers.js
//= require services/CommonServices.js
//= require filters/CommonFilters.js


    console.log("starting app");

var theatreApp = angular.module('theatreApp', [
    'theatreControllers',
    'theatreServices',
    'theatreFilters']);
