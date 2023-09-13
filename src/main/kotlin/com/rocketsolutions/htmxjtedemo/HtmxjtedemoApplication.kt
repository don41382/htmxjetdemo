package com.rocketsolutions.htmxjtedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.util.*

@SpringBootApplication
@EnableWebMvc
class HtmxjtedemoApplication

fun main(args: Array<String>) {
    runApplication<HtmxjtedemoApplication>(*args)
}
