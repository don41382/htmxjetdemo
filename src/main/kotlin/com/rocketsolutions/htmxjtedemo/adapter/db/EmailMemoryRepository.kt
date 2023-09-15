package com.rocketsolutions.htmxjtedemo.adapter.db

import com.rocketsolutions.htmxjtedemo.application.domain.Email
import org.springframework.stereotype.Component

@Component
class EmailMemoryRepository {

    private var id: Int = 0

    private var emails = listOf(
        Email(id++, "steve.jobs@apple.com"),
        Email(id++, "bill.gates@micrsoft.com"),
    )

    fun add(email: String) {
        emails += Email(
            id++,
            email,
        )
    }

    fun remove(id: Int) {
        emails = emails.filterNot { it.id == id }
    }

    fun all(): List<Email> =
        emails
}
