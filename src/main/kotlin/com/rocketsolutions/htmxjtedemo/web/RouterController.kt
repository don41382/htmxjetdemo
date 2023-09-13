package com.rocketsolutions.htmxjtedemo.web

import com.rocketsolutions.htmxjtedemo.web.index.IndexViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RouterController(
    private val index: IndexViewComponent,
) {

    @GetMapping("/")
    fun indexComponent(): IndexViewComponent.IndexView {
        return index.render()
    }
}
