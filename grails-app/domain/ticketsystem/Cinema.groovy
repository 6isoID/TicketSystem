package ticketsystem

import grails.rest.Resource


@Resource(uri='/cinema', formats=['json', 'xml'])
class Cinema {

    String name
//    List<Session> sessions

    static hasMany = Session
    static constraints = {
    }
}
