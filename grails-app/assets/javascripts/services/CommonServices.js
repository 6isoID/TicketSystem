//= require atmosphere.js

var theatreServices = angular.module('theatreServices', ['ngResource']);

theatreServices.factory('Session', [
    '$resource',
    function ($resource) {
        return $resource('/TicketSystem/session/:sessionId.json', {
            query: {method: 'GET', params: {sessionId: ''}, isArray: true}

        });
    }
]);


//got from http://spyboost.github.io/angular-atmosphere/service/angular-atmosphere-service.js
//var angularService = angular.module('angular.atmosphere', [])

theatreServices.service('atmosphereService', ['$rootScope', function($rootScope){
        var responseParameterDelegateFunctions = ['onOpen', 'onClientTimeout', 'onReopen', 'onMessage', 'onClose', 'onError'];
        var delegateFunctions = responseParameterDelegateFunctions;
        delegateFunctions.push('onTransportFailure');
        delegateFunctions.push('onReconnect');

        return {
            subscribe: function(r){
                var result = {};
                angular.forEach(r, function(value, property){
                    if(typeof value === 'function' && delegateFunctions.indexOf(property) >= 0){
                        if(responseParameterDelegateFunctions.indexOf(property) >= 0)
                            result[property] = function(response){
                                $rootScope.$apply(function(){
                                    r[property](response);
                                });
                            };
                        else if(property === 'onTransportFailure')
                            result.onTransportFailure = function(errorMsg, request){
                                $rootScope.$apply(function(){
                                    r.onTransportFailure(errorMsg, request);
                                });
                            };
                        else if(property === 'onReconnect')
                            result.onReconnect = function(request, response){
                                $rootScope.$apply(function(){
                                    r.onReconnect(request, response);
                                });
                            };
                    }else
                        result[property] = r[property];
                });

                return atmosphere.subscribe(result);
            }
        };
    }]);

console.log("services have been initiated")