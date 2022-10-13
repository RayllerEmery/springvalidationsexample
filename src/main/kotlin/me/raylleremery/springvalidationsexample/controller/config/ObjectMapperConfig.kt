package me.raylleremery.springvalidationsexample.controller.config

import com.fasterxml.jackson.databind.ObjectMapper
import me.raylleremery.springvalidationsexample.controller.common.CustomObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectMapperConfig {

    @Bean
    fun objectMapper(): ObjectMapper = CustomObjectMapper.objectMapper
}