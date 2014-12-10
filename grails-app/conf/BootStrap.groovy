//import org.joda.time.DateTime
import ticketsystem.Cinema
import ticketsystem.Hall
import ticketsystem.Seat
import ticketsystem.Session

class BootStrap {



    def init = { servletContext ->
        Hall smallHall = new Hall(rows:3, columns: 8)
        Cinema trashCinema = new Cinema(name: "Зеленый слоник", duration: 86)

        trashCinema.save()
        smallHall.save()

        Session cinemaSession = new Session(
                time: new GregorianCalendar(),
                cost: BigDecimal.ONE,
                hall: smallHall,
                cinema: trashCinema
        )
        cinemaSession.save()
    }

    def destroy = {
    }
}
