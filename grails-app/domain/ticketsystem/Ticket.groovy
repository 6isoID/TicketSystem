package ticketsystem

//Have the meaning only for client and another db
class Ticket {

    static enum State {//this is not presentable enum - several sessions, and you suck
        BLOCKED,
        RESERVED,
        SOLD
    }

    State state
    Seat seat

    static belongsTo = [session : Session]
    static constraints = {
    }
}
