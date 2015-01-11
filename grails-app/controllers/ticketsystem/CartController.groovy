package ticketsystem

import org.atmosphere.config.service.ManagedService


@ManagedService(path="/cart")
class CartController {
    static responseFormats = ['json']

    def atmosphereMeteor
    def atmosphereTestService

    def index() {
        if (!atmosphereMeteor.broadcasterFactory) {
            throw new RuntimeException("atmosphereMeteor.broadcasterFactory is null")
        }
        if (!atmosphereMeteor.framework) {
            throw new RuntimeException("atmosphereMeteor.framework is null")
        }
        println "hehehe"
//		render(view: "index")
        return Ticket.list()
    }

    def triggerPublic() {
        atmosphereTestService.triggerPublic()
        render "success"
    }

}
