package ticketsystem

import groovy.transform.ToString

@ToString
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
