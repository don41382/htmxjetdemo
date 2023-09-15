package com.rocketsolutions.htmxjtedemo.adapter.db

import com.rocketsolutions.htmxjtedemo.application.domain.Email
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class EmailMemoryRepository {

    private var emails = emptyList<Email>()

    fun add(email: String) {
        emails += Email(
            UUID.randomUUID(),
            email,
        )
    }

    fun remove(id: UUID) {
        emails = emails.filterNot { it.id == id }
    }

    fun all(): List<Email> =
        emails
}
