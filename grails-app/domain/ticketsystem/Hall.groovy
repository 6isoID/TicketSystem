package ticketsystem

import groovy.transform.Canonical
import groovy.transform.ToString

@ToString
class Hall {
    String name

    static hasMany = [seats: Seat]
    static constraints = {
    }

    //TODO transient fields ?
    Hall(int rows, int columns) {
        for (r in 1..rows) //  !!!
            for (c in 1..columns)
                this.addToSeats(new Seat(
//                        state: Seat.State.FREE,
                        rowNum: r,
                        columnNum: c
                ))
    }

    //TODO alternative mapping for seats - for example, storing the set in one field as a JSON, and unpacking here as a collection

}
