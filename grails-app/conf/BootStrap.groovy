//import org.joda.time.DateTime
import ticketsystem.Cinema
import ticketsystem.Hall
import ticketsystem.Seat
import ticketsystem.Session

class BootStrap {



    def init = { servletContext ->
        Hall smallHall = new Hall(3, 8)
        Hall bigHall = new Hall(10, 15)

        Cinema trashCinema = [name: "Зеленый слоник", duration: 86]
        Cinema aestheticCinema = [name: "Inception", duration: 130]

        trashCinema.save()
        aestheticCinema.save()

        bigHall.save()
        smallHall.save()

        Calendar nearFuture = new GregorianCalendar()
        nearFuture.add(Calendar.DAY_OF_WEEK,1)


        Session trashSession1 = [
                time: nearFuture,
                cost: BigDecimal.ONE,
                hall: smallHall,
                cinema: trashCinema
        ]
        nearFuture.add(Calendar.DAY_OF_WEEK,1)
        Session trashSession2 = [
                time: nearFuture,
                cost: BigDecimal.ONE,
                hall: smallHall,
                cinema: trashCinema
        ]

        nearFuture.add(Calendar.DAY_OF_WEEK,1)
        Session aestheticSession1 = [
                time: nearFuture,
                cost: BigDecimal.ONE,
                hall: bigHall,
                cinema: aestheticCinema
        ]
        nearFuture.add(Calendar.DAY_OF_WEEK,1)
        Session aestheticSession2 = [
                time: nearFuture,
                cost: BigDecimal.ONE,
                hall: bigHall,
                cinema: aestheticCinema
        ]

        trashSession1.save()
        trashSession2.save()
        aestheticSession1.save()
        aestheticSession2.save(flush: true)

        println Hall.list()[0].seats

        println Cinema.list()[0]
        println Session.list()[0]
    }

    def destroy = {
    }
}
