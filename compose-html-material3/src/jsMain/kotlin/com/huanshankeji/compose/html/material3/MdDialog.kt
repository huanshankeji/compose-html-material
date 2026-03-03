package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.AttrBuilderContext
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

enum class DialogType(val value: String) {
    Alert("alert")
}

@Composable
fun MdDialog(
    quick: Boolean? = null,
    returnValue: String? = null,
    type: DialogType? = null,
    noFocusTrap: Boolean? = null,
    open: Boolean? = null,
    onCancel: (() -> Unit)? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdDialogScope.() -> Unit)? = null
) {
    DialogImport // Load the web component

    TagElement("md-dialog", {
        attrIfNotNull("quick", quick)
        attrIfNotNull("return-value", returnValue)
        attrIfNotNull("type", type?.value)
        attrIfNotNull("no-focus-trap", noFocusTrap)
        attrIfNotNull("open", open)

        onCancel?.let { addEventListener("cancel") { it() } }

        attrs?.invoke(this)
    }, content?.let {
        { MdDialogScope(this).it() }
    })
}

class MdDialogScope(val elementScope: ElementScope<HTMLElement>) : SlotScope<MdDialogScope.Slot> {
    enum class Slot(override val value: String) : ISlot {
        Headline("headline"),
        Icon("icon"), // https://github.com/material-components/material-web/blob/605055229cd07ee0ca660bbc0e3255fb5f5e5914/dialog/internal/dialog.ts#L306-L308
        Content("content"),
        Actions("actions")
    }
}
