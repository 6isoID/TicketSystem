package ticketsystem

import grails.converters.JSON
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
        JSON.use("narrow"){
            render Ticket.list() as JSON
        }
    }

    def triggerPublic() {
        atmosphereTestService.triggerPublic()
        render "success"
    }

}
