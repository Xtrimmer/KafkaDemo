package com.xtrimmer

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import java.util.*

@KafkaClient
interface KafkaClient {

    @Topic("foo-stream")
    fun send(@KafkaKey key: UUID, message: Event)
}