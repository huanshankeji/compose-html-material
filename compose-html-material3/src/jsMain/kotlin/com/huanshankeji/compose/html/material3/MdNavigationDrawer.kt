package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/navigationdrawer/internal/navigation-drawer.ts
*/

@JsModule("@material/web/labs/navigationdrawer/navigation-drawer.js")
private external object NavigationDrawerImport

@JsModule("@material/web/labs/navigationdrawer/navigation-drawer-modal.js")
private external object NavigationDrawerModalImport

/**
 * From https://m3.material.io/components/navigation-drawer/overview:
 * > Note: The navigation drawer is no longer recommended in the Material 3 expressive update. For those who have updated, use an expanded navigation rail, which has mostly the same functionality of the navigation drawer and adapts better across window size classes.
 */
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
        attrIfNotNull("opened", opened)
        attrIfNotNull("pivot", pivot)

        attrs?.invoke(this)
    }, content)
}

/**
 * From https://m3.material.io/components/navigation-drawer/overview:
 * > Note:The navigation drawer is no longer recommended in the Material 3 expressive update. For those who have updated, use an expanded navigation rail, which has mostly the same functionality of the navigation drawer and adapts better across window size classes.
 */
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
        attrIfNotNull("opened", opened)
        attrIfNotNull("pivot", pivot)

        attrs?.invoke(this)
    }, content)
}
