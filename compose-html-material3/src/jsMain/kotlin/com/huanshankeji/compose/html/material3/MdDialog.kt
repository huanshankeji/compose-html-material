package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/dialog.md
https://material-web.dev/components/dialog/
https://material-web.dev/components/dialog/stories/
https://m3.material.io/components/dialogs/overview
*/

@JsModule("@material/web/dialog/dialog.js")
private external object DialogImport

@Composable
fun MdDialog(
    open: Boolean? = null,
    quick: Boolean? = null,
    returnValue: String? = null,
    type: String? = null,
    noFocusTrap: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdDialogScope.() -> Unit)? = null
) {
    DialogImport // Load the web component

    TagElement("md-dialog", {
        open?.let { attr("open", it) }
        quick?.let { attr("quick", it) }
        returnValue?.let { attr("return-value", it) }
        type(type)
        noFocusTrap?.let { attr("no-focus-trap", it) }

        attrs?.invoke(this)
    }, content?.let {
        { MdDialogScope(this).it() }
    })
}

class MdDialogScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqHeadline() =
        slot("headline")

    fun AttrsScope<*>.slotEqContent() =
        slot("content")

    fun AttrsScope<*>.slotEqActions() =
        slot("actions")
}
