/**
 * Created by Sergey_Fedorov on 18.Dec.2014.
 */

var theatreServices = angular.module('theatreServices', ['ngResource']);

theatreServices.factory('Session', [
    '$resource',
    function ($resource) {
        return $resource('/TicketSystem/session/:sessionId.json', {}, {
            query: {method: 'GET', params: {sessionId: ''}, isArray: true}
        });
    }
]);

console.log("services have been initiated")