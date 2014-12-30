package ticketsystem

import org.atmosphere.config.service.ManagedService


@ManagedService(path="/cart")
class CartController {
    static responseFormats = ['json']


    def index() { }
}
