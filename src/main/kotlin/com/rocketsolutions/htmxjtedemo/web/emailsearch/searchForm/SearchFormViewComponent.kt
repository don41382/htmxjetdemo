package com.rocketsolutions.htmxjtedemo.web.emailsearch.searchForm

import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import jakarta.servlet.http.HttpServletResponse

@ViewComponent
class SearchFormViewComponent {

    data class SearchFormView(val searchQuery: String) : ViewContext

    fun render(query: String): ViewContext =
        SearchFormView(query)

    @PostViewAction
    fun search(searchQuery: String, response: HttpServletResponse): ViewContext {
        response.addHeader("hx-push-url", "/search?query=$searchQuery")
        response.addHeader("HX-Trigger", "refreshSearchListView")
        // TODO why can't I return `EmptyViewContext`? Leads to an exception
        return render(searchQuery)
    }
}
