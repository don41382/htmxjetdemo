package com.rocketsolutions.htmxjtedemo.web.emailsearch.searchList

import com.rocketsolutions.htmxjtedemo.adapter.db.EmailMemoryRepository
import com.rocketsolutions.htmxjtedemo.application.domain.Email
import de.tschuehly.spring.viewcomponent.core.action.GetViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.RequestParam

@ViewComponent
class SearchListViewComponent(
    private val repository: EmailMemoryRepository,
) {

    data class SearchListView(val emails: List<Email>) : ViewContext

    fun render(query: String?): ViewContext {
        val filteredEmails = if (query == null) {
            repository.all()
        } else {
            repository.all().filter { it.email.contains(query.lowercase()) }
        }
        return SearchListView(filteredEmails)
    }

    // TODO is it possible to use a `@GetMapping` inside a `@ViewComponent` - this would help.
    // `@GetViewAction` e.g. does not support `@PathVariable`
    @GetViewAction
    fun refresh(@RequestParam("query") query: String?, response: HttpServletResponse): ViewContext {
        println(query)
        return render(query)
    }
}
