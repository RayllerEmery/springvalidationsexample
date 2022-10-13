package me.raylleremery.springvalidationsexample.controller.common

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.security.crypto.codec.Utf8
import java.text.SimpleDateFormat
import java.util.*

object CustomObjectMapper {

    val objectMapper: ObjectMapper = jacksonMapperBuilder()
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
        .defaultDateFormat(SimpleDateFormat("dd/MM/yyyy"))
        .defaultTimeZone(TimeZone.getDefault())
        .addModules(
            JavaTimeModule(),
            SimpleModule().addSerializer(Utf8::class.java, ToStringSerializer(Utf8::class.java))
        )
        .build()

    fun <T> toJson(value: T): String = objectMapper.writeValueAsString(value)

    fun <T> fromJson(value: String, clazz: Class<T>): T = objectMapper.readValue(value, clazz)
}