import ticketsystem.Cinema
import ticketsystem.Hall
import ticketsystem.Session

class BootStrap {

    private Seat

    def init = { servletContext ->
        Cinema cinema = new Cinema(
                name: "Зеленый слоник",
                sessions: [new Session(
                    time: new GregorianCalendar(),
                    cost: BigDecimal.ONE,
                    hall:  new Hall(
                            seats: [
                                    [],
                                    [],
                                    []
                            ]
                    )
                )])
        cinema.save()

    }

    def destroy = {
    }
}
