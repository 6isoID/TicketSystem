package ticketsystem

import grails.rest.Resource
import groovy.transform.ToString

@ToString
@Resource(uri = '/session', formats = ['json', 'xml'])
class Session {

    Calendar time
    BigDecimal cost

    static belongsTo = [cinema: Cinema, hall: Hall]
    static mapping = {
    }
    static constraints = {
    }

    //TODO validation for time - there is no duration validation
}
