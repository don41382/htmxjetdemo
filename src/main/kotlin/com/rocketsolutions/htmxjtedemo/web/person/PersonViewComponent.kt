package com.rocketsolutions.htmxjtedemo.web.person

import de.tschuehly.spring.viewcomponent.core.action.GetViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.PathVariable
import kotlin.random.Random

@ViewComponent
class PersonViewComponent() {

    fun new(name: String) = PersonView(Random.nextInt().toString(), name)
    fun render(id: String, name: String) = PersonView(id, name)
    data class PersonView(val id: String, val name: String) : ViewContext

    @GetViewAction("/personviewcomponent/newname/{id}")
    fun newName(@PathVariable id: String, response: HttpServletResponse): PersonView {
        response.setHeader("HX-Trigger", "demo-trigger-event")
        return render(id, "Klaus (${Random.nextInt()})")
    }
}
