package com.rocketsolutions.htmxjtedemo.web

import com.rocketsolutions.htmxjtedemo.application.domain.Role
import com.rocketsolutions.htmxjtedemo.web.emailadd.EmailAddViewComponent
import com.rocketsolutions.htmxjtedemo.web.emailsearch.SearchViewComponent
import com.rocketsolutions.htmxjtedemo.web.home.HomeViewComponent
import com.rocketsolutions.htmxjtedemo.web.layout.LayoutViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class RouterController(
    private val layout: LayoutViewComponent,
    private val home: HomeViewComponent,
    private val emailadd: EmailAddViewComponent,
    private val search: SearchViewComponent,
) {

    @GetMapping("/")
    fun indexComponent(): LayoutViewComponent.LayoutView {
        return layout.render(home.render())
    }

    @GetMapping("/add")
    fun add(): LayoutViewComponent.LayoutView {
        return layout.render(emailadd.render())
    }

    @GetMapping("/search")
    fun search(
        @RequestParam("query") query: String?,
        @RequestParam("roles", defaultValue = "") roles: List<Role>,
    ): LayoutViewComponent.LayoutView {
        return layout.render(search.render(query.orEmpty(), roles))
    }
}
