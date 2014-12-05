package ticketsystem

class Hall {

    //List<List<Seat>> seats


    static List<Seat> createEmptyHall(int rows, int columns) {
        List<Seat> seats = []
        for(r in 1..rows) //  !!!
            for(c in 1..columns)
                seats.add(new Seat(
                        state: Seat.State.FREE,
                        rowNum: r,
                        columnNum: c
                ))
        return seats
    }

    static belongsTo = Session
    static hasMany = [ seats:  Seat ]
    static constraints = {
    }
}
