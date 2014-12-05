package ticketsystem

class Seat {

    static enum State {
        FREE,
        BLOCKED,
        RESERVED,
        SOLD
    }

    //THAT is wierd
    int rowNum
    int columnNum
    //TODO move to mongoDB

    State state

    static belongsTo = [ hall: Hall ]
    static constraints = {
    }
}
