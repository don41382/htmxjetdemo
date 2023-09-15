package com.rocketsolutions.htmxjtedemo.web.emailadd

import com.rocketsolutions.htmxjtedemo.web.emailform.EmailAddFormViewComponent
import com.rocketsolutions.htmxjtedemo.web.emaillist.EmailListViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class EmailAddViewComponent(
    val emailAddFormViewComponent: EmailAddFormViewComponent,
    val emailListViewComponent: EmailListViewComponent,
) {

    data class EmailAddView(
        val emailAddForm: ViewContext,
        val emailListView: ViewContext,
    ) : ViewContext

    fun render(): EmailAddView = EmailAddView(
        emailAddFormViewComponent.render(),
        emailListViewComponent.render(),
    )
}
