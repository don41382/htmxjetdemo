package com.rocketsolutions.htmxjtedemo.web.emaillist

import com.rocketsolutions.htmxjtedemo.adapter.db.EmailMemoryRepository
import com.rocketsolutions.htmxjtedemo.application.domain.Email
import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class EmailListViewComponent(
    val repository: EmailMemoryRepository,
) {
    data class EmailListView(val emails: List<Email>) : ViewContext

    fun render() =
        EmailListView(repository.all())

    @PostViewAction
    fun refresh() =
        render()
}
