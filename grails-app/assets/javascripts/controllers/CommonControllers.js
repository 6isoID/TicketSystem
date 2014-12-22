
//TODO http://stackoverflow.com/a/20000089

//TODO http://www.html5rocks.com/en/tutorials/frameworks/angular-websockets/
//compile ":atmosphere-meteor:1.0.4"

var theatreControllers = angular.module('theatreControllers', []);


theatreControllers.controller('SessionController', [
    '$scope',
    'Session',
    function ($scope, Session) {
        var createRows = function (seatList) {
            var rows = [];
            var seat;
            for (var i = 0; i < seatList.length; i++) {
                seat = seatList[i];
                if (!rows[seat.rowNum-1])rows[seat.rowNum-1] = [];
                rows[seat.rowNum-1][seat.columnNum-1] = seat;
            }
            return rows;
        }

        Session.query().$promise.then(function (response) {
            var session = null;
            for (var i = 0; i < response.length; i++) {
                response[i].rows = createRows(response[i].hall.seats);
            }
            $scope.sessions = response;
        });
    }
])

theatreControllers.controller('TimeHelperController')


console.log("controllers have been initiated");