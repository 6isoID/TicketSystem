//import org.joda.time.DateTime
import ticketsystem.Cinema
import ticketsystem.Hall
import ticketsystem.Seat
import ticketsystem.Session

class BootStrap {



    def init = { servletContext ->
        Hall smallHall = new Hall(3, 8)
        Cinema trashCinema = [name: "Зеленый слоник", duration: 86]

        trashCinema.save()
        smallHall.save()

        Calendar nearFuture = new GregorianCalendar()
        nearFuture.add(Calendar.DAY_OF_WEEK,1)

        Session cinemaSession = [
                time: nearFuture,
                cost: BigDecimal.ONE,
                hall: smallHall,
                cinema: trashCinema
        ]
        cinemaSession.save(flush: true)

        println Hall.list()[0].seats

        println Cinema.list()[0]
        println Session.list()[0]
    }

    def destroy = {
    }
}
