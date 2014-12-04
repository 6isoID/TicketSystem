package ticketsystem

class Seat {

    enum State {
        FREE,
        RESERVED,
        SOLD
    }

    State state

    static constraints = {
    }
}
