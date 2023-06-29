package com.doodlekong.whbnd

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.doodlekong.whbnd.plugins.*
import com.doodlekong.whbnd.routes.createRoomRoute
import com.doodlekong.whbnd.session.DrawingSession
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.*

fun main() {
    embeddedServer(Netty, port = 8023, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

val server = DrawingServer()

fun Application.module() {
    install(Sessions) {
        cookie<DrawingSession>("SESSION")
    }
    intercept(ApplicationCallPipeline.Plugins) {
        if (call.sessions.get<DrawingSession>() == null) {
            val clientId = call.parameters["clientId"] ?: ""
            call.sessions.set(DrawingSession(clientId, generateNonce()))
        }
    }

    configureSerialization()
    configureSockets()
    configureMonitoring()
    configureRouting()
}
