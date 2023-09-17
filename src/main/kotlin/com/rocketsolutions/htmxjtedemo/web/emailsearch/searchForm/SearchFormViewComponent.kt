package com.rocketsolutions.htmxjtedemo.web.emailsearch.searchForm

import com.rocketsolutions.htmxjtedemo.application.domain.Role
import com.rocketsolutions.htmxjtedemo.application.domain.RoleConvert.toRoles
import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import jakarta.servlet.http.HttpServletResponse

@ViewComponent
class SearchFormViewComponent {

    data class SearchFormView(val query: String, val selectedRoles: List<Role>) : ViewContext

    fun render(query: String, roles: List<Role>): ViewContext =
        SearchFormView(query, roles)

    @PostViewAction
    fun search(query: String, roles: String?, response: HttpServletResponse): ViewContext {
        val roles = roles.toRoles()
        response.addHeader("hx-push-url", "/search?query=$query&roles=${roles.joinToString(",")}")
        response.addHeader("HX-Trigger", TRIGGER_REFRESH_SEARCH)
        // TODO why can't I return `EmptyViewContext`? Leads to an exception
        return SearchFormView(query, roles)
    }

    companion object {
        const val TRIGGER_REFRESH_SEARCH = "refreshSearchListView"
    }
}
