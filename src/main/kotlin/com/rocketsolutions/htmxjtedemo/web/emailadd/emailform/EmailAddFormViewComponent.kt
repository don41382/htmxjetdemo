package com.rocketsolutions.htmxjtedemo.web.emailadd.emailform

import com.rocketsolutions.htmxjtedemo.adapter.db.EmailMemoryRepository
import com.rocketsolutions.htmxjtedemo.web.emailadd.emaillist.EmailListViewComponent
import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import jakarta.servlet.http.HttpServletResponse

@ViewComponent
class EmailAddFormViewComponent(
    val repo: EmailMemoryRepository,
    val emailListViewComponent: EmailListViewComponent,
) {

    data class EmailAddForm(
        val emailField: String,
        val error: String?,
    ) : ViewContext

    fun render(): EmailAddForm = EmailAddForm(
        "",
        null,
    )

    @PostViewAction
    fun addEmail(emailField: String, response: HttpServletResponse): EmailAddForm {
        response.addHeader("HX-Trigger", ADD_REFRESH_TRIGGER)
        return if (emailField.contains("@")) {
            repo.add(emailField)
            EmailAddForm(
                "",
                null,
            )
        } else {
            EmailAddForm(
                emailField,
                "Invalid E-Mail.",
            )
        }
    }

    companion object {
        const val ADD_REFRESH_TRIGGER = "ADD_EMAIL"
    }
}
