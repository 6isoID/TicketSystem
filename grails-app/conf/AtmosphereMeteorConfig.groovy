import ticketsystem.DefaultMeteorHandler
import ticketsystem.DefaultMeteorServlet

defaultMapping = "/atmosphere/*"


def defaultInitParams = [
		"org.atmosphere.cpr.broadcasterCacheClass": "org.atmosphere.cache.UUIDBroadcasterCache",
		"org.atmosphere.cpr.AtmosphereInterceptor": """
			org.atmosphere.client.TrackMessageSizeInterceptor,
			org.atmosphere.interceptor.AtmosphereResourceLifecycleInterceptor,
			org.atmosphere.interceptor.HeartbeatInterceptor
		"""
]

/*
 name (index), className, and mapping are used by
 AtmosphereMeteorGrailsPlugin.doWithWebDescriptor to create the servlets in web.xml.

 mapping and handler are used by the DefaultMeteorServlet class
 to add each AtmosphereHandler to the AtmosphereFramework.

 Uncomment and edit the example below to configure your servlets
*/


servlets = [
		MeteorServlet: [
				className: "ticketsystem.DefaultMeteorServlet",
				mapping: defaultMapping,
				handler: DefaultMeteorHandler,
				initParams: defaultInitParams
		]
//		MeteorServletTicket: [
//				className: "org.grails.plugins.atmosphere_meteor_sample.DefaultMeteorServlet",
//				mapping: "/atmosphere/ticket/*",
//				handler: TicketMeteorHandler,
//				initParams: defaultInitParams
//		],
]


servlets = [

]
