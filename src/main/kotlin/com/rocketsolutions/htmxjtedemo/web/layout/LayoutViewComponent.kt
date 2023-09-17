package com.rocketsolutions.htmxjtedemo.web.layout

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class LayoutViewComponent {
    fun render(content: ViewContext) = LayoutView(content)
    data class LayoutView(val content: ViewContext) : ViewContext
}
