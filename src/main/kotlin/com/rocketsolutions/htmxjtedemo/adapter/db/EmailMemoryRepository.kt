package com.rocketsolutions.htmxjtedemo.adapter.db

import com.rocketsolutions.htmxjtedemo.application.domain.Email
import com.rocketsolutions.htmxjtedemo.application.domain.Role
import org.springframework.stereotype.Component

@Component
class EmailMemoryRepository {

    private var id: Int = 0

    private var emails = listOf(
        Email(id++, "steve.jobs@apple.com", Role.CEO),
        Email(id++, "bill.gates@microsoft.com", Role.CEO),
        Email(id++, "mark.zuckerberg@facebook.com", Role.CEO),
        Email(id++, "larry.page@google.com", Role.CEO),
        Email(id++, "sergey.brin@google.com", Role.Inventor),
        Email(id++, "elon.musk@tesla.com", Role.Inventor),
        Email(id++, "jeff.bezos@amazon.com", Role.CEO),
        Email(id++, "linus.torvalds@linux.com", Role.Inventor),
        Email(id++, "tim.berners-lee@w3.org", Role.Research),
        Email(id++, "sundar.pichai@google.com", Role.CEO),
        Email(id++, "satya.nadella@microsoft.com", Role.Engineer),
        Email(id++, "jack.dorsey@twitter.com", Role.Engineer),
        Email(id++, "brian.chesky@airbnb.com", Role.Engineer),
        Email(id++, "eckhardt@rocket-solutions.de", Role.Engineer),
    )

    fun add(email: String) {
        emails += Email(
            id++,
            email,
            Role.CEO,
        )
    }

    fun remove(id: Int) {
        emails = emails.filterNot { it.id == id }
    }

    fun all(): List<Email> =
        emails
}
