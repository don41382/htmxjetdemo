package com.rocketsolutions.htmxjtedemo.web.emailadd.emaillist

import com.rocketsolutions.htmxjtedemo.adapter.db.EmailMemoryRepository
import com.rocketsolutions.htmxjtedemo.application.domain.Email
import de.tschuehly.spring.viewcomponent.core.action.DeleteViewAction
import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import org.springframework.web.bind.annotation.RequestParam

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

    @DeleteViewAction
    fun delete(@RequestParam("id") id: Int): ViewContext {
        repository.remove(id)
        return render()
    }
}
