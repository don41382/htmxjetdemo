package com.rocketsolutions.htmxjtedemo.web.emailform

import com.rocketsolutions.htmxjtedemo.adapter.db.EmailMemoryRepository
import com.rocketsolutions.htmxjtedemo.web.emaillist.EmailListViewComponent
import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

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
    fun addEmail(emailField: String): EmailAddForm {
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
}
