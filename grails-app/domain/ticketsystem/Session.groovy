package ticketsystem

import org.joda.time.DateTime

class Session {

    DateTime time
    Hall hall
    BigDecimal cost

    static belongsTo = Cinema
    static constraints = {
    }
}
