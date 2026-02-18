package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/navigationdrawer/internal/navigation-drawer.ts
https://github.com/material-components/material-web/blob/main/labs/navigationdrawer/demo/stories.ts
*/

@JsModule("@material/web/labs/navigationdrawer/navigation-drawer.js")
private external object NavigationDrawerImport

@JsModule("@material/web/labs/navigationdrawer/navigation-drawer-modal.js")
private external object NavigationDrawerModalImport

@MaterialWebLabsApi
@Composable
fun MdNavigationDrawer(
    opened: Boolean? = null,
    pivot: String? = null, // "start" or "end"
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    NavigationDrawerImport // Load the web component

    TagElement("md-navigation-drawer", {
        opened?.let { attr("opened", it) }
        pivot?.let { attr("pivot", it) }

        attrs?.invoke(this)
    }, content)
}

@MaterialWebLabsApi
@Composable
fun MdNavigationDrawerModal(
    opened: Boolean? = null,
    pivot: String? = null, // "start" or "end"
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    NavigationDrawerModalImport // Load the web component

    TagElement("md-navigation-drawer-modal", {
        opened?.let { attr("opened", it) }
        pivot?.let { attr("pivot", it) }

        attrs?.invoke(this)
    }, content)
}
