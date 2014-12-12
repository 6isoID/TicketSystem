package ticketsystem

import groovy.transform.ToString

@ToString
class Seat {

    static enum State {
        FREE,
        BLOCKED,
        RESERVED,
        SOLD
    }

    //THAT _is_ (!)wierd
    int rowNum
    int columnNum
    //TODO move to mongoDB

    State state

    static belongsTo = [hall: Hall]
    static constraints = {
    }
}
