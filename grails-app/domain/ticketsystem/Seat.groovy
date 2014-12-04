package ticketsystem

class Seat {

    static enum State {
        FREE,
        RESERVED,
        SOLD
    }

    State state

    public static Seat buildSeat(String _state) {
         new Seat(state: State.valueOf(_state))
    }

    static constraints = {
    }
}
