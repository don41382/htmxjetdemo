package com.rocketsolutions.htmxjtedemo.web.home

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class HomeViewComponent {

    companion object HomeView : ViewContext

    fun render(): HomeView = HomeView
}
