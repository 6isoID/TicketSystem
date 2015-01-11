//import org.joda.time.DateTime  //too many PITA with gorm

import grails.converters.JSON
import org.codehaus.groovy.grails.web.converters.marshaller.json.DeepDomainClassMarshaller
import org.codehaus.groovy.grails.web.converters.marshaller.json.DomainClassMarshaller
import ticketsystem.Cinema
import ticketsystem.Hall
import ticketsystem.Seat
import ticketsystem.Session
import ticketsystem.Ticket


class BootStrap {

    def grailsApplication

    Ticket randomTicket (Session session) {
        Random r = new Random()
        int bound = session.hall.seats.size()
        for( seat in session.hall.seats) {
            if(r.nextInt(bound)>bound*0.75)
                return [
                        seat: seat,
                        state: Ticket.State.SOLD,
                        session:session
                ]
        }
        return null
    }

    void addSessionsToCinema(cinema, hall, n) {
        n.times{
            Calendar nearFuture = new GregorianCalendar()
            nearFuture.add(Calendar.DAY_OF_YEAR, it)
            Session session = [
                    time: nearFuture,
                    cost: BigDecimal.ONE,
                    hall: hall,
                    cinema: cinema
            ]
            session.save()
            //who should know about other? ticket about session? or session about ticket?

            randomTicket(session)?.save(flush: true)
        }
    }




    def init = { servletContext ->
        Hall east = new Hall(3, 8)
        east.name = 'East hall '
        east.save()
        //TODO css for big halls
        Hall west = new Hall(3, 8)
        west.name = 'West hall'
        west.save()

        Cinema trashCinema = [name: 'Зеленый слоник', duration: 86, description:'Фильм о свободе человека, о её краеугольном значении и бесценности для личности. Кино о возможных метаморфозах человеческой сущности в условиях замкнутого пространства, тотального унижения и безысходности. Фильм — о подвиге русского офицера.']
        Cinema aestheticCinema = [name: 'Inception', duration: 130, description: '«It’s really, at its core, a big action heist movie» ']

        trashCinema.save()
        aestheticCinema.save()

        addSessionsToCinema(aestheticCinema,  east, 2)
        addSessionsToCinema(trashCinema, west, 2)

        JSON.createNamedConfig('narrow'){
            //GROOVY GOODNESS, IT WORKS!!!
            it.registerObjectMarshaller( new DomainClassMarshaller(false, grailsApplication) )
        }



    }

    def destroy = {
    }
}
