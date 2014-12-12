package ticketsystem

import grails.rest.Resource
import groovy.transform.ToString

@ToString
@Resource(uri = '/cinema', formats = ['json', 'xml'])
class Cinema {

    String name
    int duration //in minutes

    static hasMany = [sessions : Session]
    static constraints = {
    }
}
