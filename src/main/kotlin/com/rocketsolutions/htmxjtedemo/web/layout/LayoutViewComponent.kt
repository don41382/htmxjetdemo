package com.rocketsolutions.htmxjtedemo.web.layout

import com.rocketsolutions.htmxjtedemo.web.person.PersonViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class LayoutViewComponent(
    private val personView: PersonViewComponent,
) {
    fun render(content: ViewContext) = LayoutView(content)

    data class LayoutView(val content: ViewContext) : ViewContext
}
