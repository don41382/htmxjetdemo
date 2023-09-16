package com.rocketsolutions.htmxjtedemo.adapter.db

import com.rocketsolutions.htmxjtedemo.application.domain.Email
import org.springframework.stereotype.Component

@Component
class EmailMemoryRepository {

    private var id: Int = 0

    private var emails = listOf(
        Email(id++, "steve.jobs@apple.com"),
        Email(id++, "bill.gates@microsoft.com"),
        Email(id++, "mark.zuckerberg@facebook.com"),
        Email(id++, "larry.page@google.com"),
        Email(id++, "sergey.brin@google.com"),
        Email(id++, "elon.musk@tesla.com"),
        Email(id++, "jeff.bezos@amazon.com"),
        Email(id++, "linus.torvalds@linux.com"),
        Email(id++, "tim.berners-lee@w3.org"),
        Email(id++, "sundar.pichai@google.com"),
        Email(id++, "satya.nadella@microsoft.com"),
        Email(id++, "jack.dorsey@twitter.com"),
        Email(id++, "brian.chesky@airbnb.com"),
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
