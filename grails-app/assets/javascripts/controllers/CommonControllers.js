
// TODO https://github.com/spyboost/atmosphere-chat-angular

//TODO http://stackoverflow.com/a/20000089

//TODO http://www.html5rocks.com/en/tutorials/frameworks/angular-websockets/
//compile ":atmosphere-meteor:1.0.4"
//angular.module('angular.atmosphere.cart', ['angular.atmosphere']);

var theatreControllers = angular.module('theatreControllers', ['angular.atmosphere']);


theatreControllers.controller('SessionController', [
    '$scope',
    'Session',
    function ($scope, Session, atmosphereService) {
        var createRows = function (seatList) {
            var rows = [];
            var seat;
            for (var i = 0; i < seatList.length; i++) {
                seat = seatList[i];
                if (!rows[seat.rowNum - 1])rows[seat.rowNum - 1] = [];
                rows[seat.rowNum - 1][seat.columnNum - 1] = seat;
            }
            return rows;
        }
        $scope.cart = {};


        $scope.addToCart = function($event) {
            var msg = JSON.parse(event.path[0].id);
            //TODO change color of seats
            $scope.cart[event.path[0].id] = msg;
        }


        //TODO move code to service
        $scope.submitCart = function() {
            var cart = [];
            for(var obj in $scope.cart) {
                cart.push($scope.cart[obj]);
            }
            $scope.cart = {};
            if(cart.length > 0) console.log(cart) //here should be atmosphere submit
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

                if (!cinemas[id]) {
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




        $scope.model = {
            transport: 'websocket',
            messages: []
        };

        var socket;

        var request = {
            url: '/cart',
            contentType: 'application/json',
            logLevel: 'debug',
            transport: 'websocket',
            trackMessageLength: true,
            reconnectInterval: 5000,
            enableXDR: true,
            timeout: 60000
        };

        //  bulk
        // =======================
        request.onOpen = function (response) {
            $scope.model.transport = response.transport;
            $scope.model.connected = true;
            $scope.model.content = 'Atmosphere connected using ' + response.transport;
        };

        request.onClientTimeout = function (response) {
            $scope.model.content = 'Client closed the connection after a timeout. Reconnecting in ' + request.reconnectInterval;
            $scope.model.connected = false;

            socket.push(atmosphere.util.stringifyJSON({
                message: 'Client is inactive and closed the connection. Will reconnect in ' + request.reconnectInterval
            }));

            setTimeout(function () {
                socket = atmosphereService.subscribe(request);
            }, request.reconnectInterval);


        };

        request.onReopen = function (response) {
            $scope.model.connected = true;
            $scope.model.content = 'Atmosphere re-connected using ' + response.transport;
        };


        //For demonstration of how you can customize the fallbackTransport using the onTransportFailure function
        request.onTransportFailure = function (errorMsg, request) {
            atmosphere.util.info(errorMsg);
            request.fallbackTransport = 'long-polling';
            $scope.model.header = 'Something went wrong. Default transport is WebSocket, fallback is ' + request.fallbackTransport;
        };


        request.onMessage = function (response) {
            var responseText = response.responseBody;
            try {
                var message = atmosphere.util.parseJSON(responseText);
                //TODO
                //if (!$scope.model.logged && $scope.model.name)
                //    $scope.model.logged = true;
                //else {
                //    var date = typeof(message.time) === 'string' ? parseInt(message.time) : message.time;
                //    $scope.model.messages.push({author: message.author, date: new Date(date), text: message.message});
                //}
            } catch (e) {
                console.error("Error parsing JSON: ", responseText);
                throw e;
            }
        };


        request.onClose = function (response) {
            $scope.model.connected = false;
            $scope.model.content = 'Server closed the connection after a timeout';
            socket.push(atmosphere.util.stringifyJSON({message: 'disconnecting'}));
        };


        request.onError = function (response) {
            $scope.model.content = "Sorry, but there's some problem with your socket or the server is down";
            $scope.model.logged = false;
        };


        request.onReconnect = function (request, response) {
            $scope.model.content = 'Connection lost. Trying to reconnect ' + request.reconnectInterval;
            $scope.model.connected = false;
        };

        socket = atmosphereService.subscribe(request);



    }
])

theatreControllers.controller('TimeHelperController')


console.log("controllers have been initiated");