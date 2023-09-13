package com.rocketsolutions.htmxjtedemo.web.index

import com.rocketsolutions.htmxjtedemo.web.person.PersonViewComponent
import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class IndexViewComponent(
    private val personView: PersonViewComponent
) {
    fun render() = IndexView(personView)

    data class IndexView(val personview: PersonViewComponent) : ViewContext

    @PostViewAction
    fun testAction(): IndexView {
        return render()
    }
}
