package ticketsystem

class Seat {

    static enum State {
        FREE,
        BLOCKED,
        RESERVED,
        SOLD
    }

//    Hall hall
    //THAT is wierd
    int rowNum
    int columnNum
    //TODO move to mongoDB

    State state

//    static hasOne = [rowNum: int, columnNum: int, state: State]
    static belongsTo = [hall: Hall]
    static constraints = {
    }
}
