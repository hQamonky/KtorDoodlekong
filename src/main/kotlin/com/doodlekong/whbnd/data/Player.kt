package com.doodlekong.whbnd.data

import com.doodlekong.whbnd.data.models.Ping
import com.doodlekong.whbnd.gson
import com.doodlekong.whbnd.server
import com.doodlekong.whbnd.util.Constants
import com.doodlekong.whbnd.util.Constants.PING_FREQUENCY
import io.ktor.websocket.*
import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
data class Player(
    val username: String,
    var socket: WebSocketSession,
    val clientId: String,
    var isDrawing: Boolean = false,
    var score: Int = 0,
    var rank: Int = 0
) {

    private var pingJob: Job? = null

    private var pingTime = 0L
    private var pongTime = 0L

    var isOnline = true

    fun startPinging() {
        pingJob?.cancel()
        pingJob = GlobalScope.launch {
            while(true) {
                sendPing()
                delay(Constants.PING_FREQUENCY)
            }
        }
    }

    private suspend fun sendPing() {
        pingTime = System.currentTimeMillis()
        socket.send(Frame.Text(gson.toJson(Ping())))
        delay(PING_FREQUENCY)
        if (pingTime - pongTime > PING_FREQUENCY) {
            isOnline = false
            server.playerLeft(clientId)
            pingJob?.cancel()
        }
    }

    fun receivedPong() {
        pongTime = System.currentTimeMillis()
        isOnline = true
    }

    fun disconnect() {
        pingJob?.cancel()
    }
}
