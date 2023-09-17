package com.rocketsolutions.htmxjtedemo.web.emailsearch

import com.rocketsolutions.htmxjtedemo.application.domain.Role
import com.rocketsolutions.htmxjtedemo.web.emailsearch.searchForm.SearchFormViewComponent
import com.rocketsolutions.htmxjtedemo.web.emailsearch.searchList.SearchListViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class SearchViewComponent(
    private val searchForm: SearchFormViewComponent,
    private val searchList: SearchListViewComponent,
) {

    data class SearchView(val searchForm: ViewContext, val searchList: ViewContext) : ViewContext

    fun render(query: String, roles: List<Role>): ViewContext =
        SearchView(
            searchForm = searchForm.render(query, roles),
            searchList = searchList.render(query, roles),
        )
}
