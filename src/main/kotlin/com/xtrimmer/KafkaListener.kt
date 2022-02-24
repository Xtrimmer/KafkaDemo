package com.xtrimmer

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.LoggerFactory
import java.util.*

@KafkaListener(groupId = "message")
class KafkaListener {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Topic("foo-stream")
    fun receive(@KafkaKey key: UUID, message: Event) {
        log.info("Message '$message' received with key '$key'")
    }
}