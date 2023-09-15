package com.rocketsolutions.htmxjtedemo.web

import com.rocketsolutions.htmxjtedemo.web.emailadd.EmailAddViewComponent
import com.rocketsolutions.htmxjtedemo.web.home.HomeViewComponent
import com.rocketsolutions.htmxjtedemo.web.layout.LayoutViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RouterController(
    private val layout: LayoutViewComponent,
    private val home: HomeViewComponent,
    private val emailadd: EmailAddViewComponent,
) {

    @GetMapping("/")
    fun indexComponent(): LayoutViewComponent.LayoutView {
        return layout.render(home.render())
    }

    @GetMapping("/add")
    fun add(): LayoutViewComponent.LayoutView {
        return layout.render(emailadd.render())
    }
}
