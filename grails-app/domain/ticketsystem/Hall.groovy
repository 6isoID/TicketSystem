package ticketsystem

import groovy.transform.Canonical


class Hall {

    static hasMany = [seats: Seat]
    static constraints = {
    }


    Hall(int rows, int columns) {
        def seatlist = []
        for (r in 1..rows) //  !!!
            for (c in 1..columns)
                seatlist.add(new Seat(
                        state: Seat.State.FREE,
                        rowNum: r,
                        columnNum: c
                ))
        seats.addAll(seatlist)
    }

    //TODO alternative mapping for seats - for example, storing the set in one field as a JSON, and unpacking here as a collection

}
