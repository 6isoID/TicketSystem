
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

        
        //client has another BC - translating session list into cinema list
        Session.query().$promise.then(function (response) {
            $scope.cinemas = {};
            var cinemas = $scope.cinemas;
            var cinema = null;
            var session = null;
            var id = null;
            for (var i = 0; i < response.length; i++) {
                session = response[i];
                id = session.cinema.id;

                if(!cinemas[id]){
                    cinemas[id] = session.cinema;
                    cinemas[id].sessions = [];
                }
                cinema = cinemas[id];
                session.rows = createRows(session.hall.seats);
                delete session.cinema;
                cinema.sessions.push(session);

            }
            console.log(cinemas);
            $scope.sessions = response;
        });
    }
])

theatreControllers.controller('TimeHelperController')


console.log("controllers have been initiated");