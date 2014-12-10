package ticketsystem

import grails.rest.Resource


@Resource(uri = '/cinema', formats = ['json', 'xml'])
class Cinema {

    String name
    int duration //in minutes

    static hasMany = [sessions : Session]
    static constraints = {
    }
}
