package com.huanshankeji.compose.html.material3.maicol07.materialwebadditions

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.html.material3.ExperimentalComposeHtmlMaterialApi
import com.huanshankeji.compose.html.material3.ISlot
import com.huanshankeji.compose.html.material3.SlotScope
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/maicol07/material-web-additions/blob/main/docs/components/snackbar.md
https://material-web-additions.maicol07.it/components/snackbar/
https://m3.material.io/components/snackbar
*/

@JsModule("@maicol07/material-web-additions/snackbar/snackbar.js")
private external object SnackbarImport

@MaterialWebAdditionsApi
@Composable
fun MdSnackbar(
    open: Boolean? = null,
    twoLines: Boolean? = null,
    actionText: String? = null,
    fixed: Boolean? = null,
    timeout: Number? = null,
    // https://github.com/maicol07/material-web-additions/blob/main/snackbar/internal/snackbar.ts
    onAction: (() -> Unit)? = null,
    onOpen: (() -> Unit)? = null,
    onOpened: (() -> Unit)? = null,
    onClose: (() -> Unit)? = null,
    onClosed: (() -> Unit)? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable MdSnackbarScope.() -> Unit
) {
    SnackbarImport // Load the web component

    TagElement("md-snackbar", {
        attrIfNotNull("open", open)
        attrIfNotNull("two-lines", twoLines)
        attrIfNotNull("action-text", actionText)
        attrIfNotNull("fixed", fixed)
        attrIfNotNull("timeout", timeout)

        onAction?.let { addEventListener("action") { it() } }
        onOpen?.let { addEventListener("open") { it() } }
        onOpened?.let { addEventListener("opened") { it() } }
        onClose?.let { addEventListener("close") { it() } }
        onClosed?.let { addEventListener("closed") { it() } }

        attrs?.invoke(this)
    }) {
        MdSnackbarScope(this).content()
    }
}

// https://github.com/maicol07/material-web-additions/blob/main/snackbar/internal/snackbar.ts
@ExperimentalComposeHtmlMaterialApi
class MdSnackbarScope(val elementScope: ElementScope<HTMLElement>) : SlotScope<MdSnackbarScope.Slot> {
    enum class Slot(override val value: String) : ISlot {
        Action("action"),
        Icon("icon")
    }
}
