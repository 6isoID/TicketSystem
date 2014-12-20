'use strict';


//TODO http://stackoverflow.com/a/20000089

//TODO http://www.html5rocks.com/en/tutorials/frameworks/angular-websockets/
//compile ":atmosphere-meteor:1.0.4"

var theatreControllers = angular.module('theatreControllers', []);


theatreControllers.controller('SessionController', [
    '$scope',
    'Session',
    function ($scope, Session) {
        $scope.sessions = Session.query();
        //TODO remove
        window.sessions = $scope.sessions;

        //TODO interceptor http://stackoverflow.com/questions/21927819/angularjs-transform-response-in-resource-using-a-custom-service
        //$scope.sessions.promise().then(function (resources) {
        //    console.log("then: ");
        //    console.log(resources)
        //})
        console.log($scope.sessions)
        //for(var session in $scope.sessions) {
        //    session.time = new Date(session.time.timeInMillis);
        //}
        //$scope.getRows = function(session) {
        //    console.log(session.id);
        //    var seats = session.hall.seats;
        //
        //    return [[1,2,3],[1,2,3]];
        //}
    }
])

theatreControllers.controller('TimeHelperController')


console.log("controllers have been initiated");