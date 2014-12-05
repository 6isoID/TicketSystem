import org.joda.time.DateTime
import ticketsystem.Cinema
import ticketsystem.Hall
import ticketsystem.Seat
import ticketsystem.Session

class BootStrap {



    //
   // @Newify([Cinema, Session, DateTime, Hall])
    def init = { servletContext ->

        Cinema cinema = new Cinema(
                name: "Зеленый слоник",
                sessions: [ new Session(
                    time: new DateTime(),
                    cost: BigDecimal.ONE,
                    hall: new Hall(seats: Hall.createEmptyHall(3,8))
                )])
        cinema.save()

    }

    def destroy = {
    }
}
