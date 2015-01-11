package ticketsystem

import grails.converters.JSON

class AtmosphereTestController {

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
		println ':_:'
		List tickets =  Ticket.list()
		println tickets

//		render(view: "index")
		JSON.use("narrow"){
			render tickets as JSON
		}
	}
	
	def triggerPublic() {
		atmosphereTestService.triggerPublic()
		render "success"
	}
}
