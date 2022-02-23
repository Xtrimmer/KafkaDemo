package com.xtrimmer

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.util.*

@Controller("/api")
class Controller(private val kafkaClient: KafkaClient) {

    companion object {
        private var counter = 0
    }

    @Get("/test")
    fun test() : String {
        val message = "Test Message ${++counter}"
        val key = UUID.randomUUID()
        kafkaClient.send(key, message)

        return "Message '$message' published with key '$key'"
    }
}