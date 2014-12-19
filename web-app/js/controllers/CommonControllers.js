'use strict';


//TODO http://stackoverflow.com/a/20000089

//TODO http://www.html5rocks.com/en/tutorials/frameworks/angular-websockets/
//compile ":atmosphere-meteor:1.0.4"

var theatreControllers = angular.module('theatreControllers',[]);



theatreControllers.controller('SessionController', [
    '$scope',
    'Session',
    function($scope, Session) {
        $scope.sessions = Session.query();
        //for(var session in $scope.sessions) {
        //    session.time = new Date(session.time.timeInMillis);
        //}
    }
])

theatreControllers.controller('TimeHelperController')


console.log("controllers have been initiated");