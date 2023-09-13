package com.rocketsolutions.htmxjtedemo.web.person

import de.tschuehly.spring.viewcomponent.core.action.GetViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class PersonViewComponent() {
    fun render(name: String) = PersonView(name)
    data class PersonView(val name: String) : ViewContext

    @GetViewAction
    fun newName() = render("Klaus")
}
