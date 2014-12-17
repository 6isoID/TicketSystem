package ticketsystem

import groovy.transform.ToString

@ToString
class Seat {

    //THAT _is_ (!)wierd
    int rowNum
    int columnNum
    //TODO move to mongoDB
    //TODO create custom mapping - serialize it as a string


    static belongsTo = [hall: Hall]
    static constraints = {
    }
}
