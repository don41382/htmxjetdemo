package com.rocketsolutions.htmxjtedemo.application.domain

import java.util.*

data class Email(val id: Int, val email: String, val role: Role)

enum class Role {
    CEO, Research, Inventor, Engineer
}
object RoleConvert {
    fun String?.toRoles(): List<Role> =
        Role.values().filter { r -> this.orEmpty().contains(r.name) }
}
