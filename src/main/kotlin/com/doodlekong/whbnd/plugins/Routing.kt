package com.doodlekong.whbnd.plugins

import com.doodlekong.whbnd.routes.createRoomRoute
import com.doodlekong.whbnd.routes.getRoomsRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        createRoomRoute()
        getRoomsRoute()
    }
}
