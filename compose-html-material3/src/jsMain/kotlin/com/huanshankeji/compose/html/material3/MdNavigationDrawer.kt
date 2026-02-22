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
https://github.com/material-components/material-web/blob/main/labs/navigationdrawer/internal/navigation-drawer.ts
https://github.com/material-components/material-web/blob/main/labs/navigationdrawer/demo/stories.ts
https://github.com/material-components/material-web/blob/main/labs/navigationdrawer/README.md
https://material-web.dev/components/navigation-drawer/
https://m3.material.io/components/navigation-drawer/overview
*/

@JsModule("@material/web/labs/navigationdrawer/navigation-drawer.js")
private external object NavigationDrawerImport

@JsModule("@material/web/labs/navigationdrawer/navigation-drawer-modal.js")
private external object NavigationDrawerModalImport

enum class NavigationDrawerPivot(val value: String) {
    Start("start"), End("end")
}

private fun <T> (@Composable T.() -> Unit)?.toElementScopeContent(
    scopeFactory: (ElementScope<HTMLElement>) -> T
): (@Composable ElementScope<HTMLElement>.() -> Unit)? =
    this?.let {
        { scopeFactory(this).it() }
    }

@MaterialWebLabsApi
@Composable
fun MdNavigationDrawer(
    opened: Boolean? = null,
    pivot: NavigationDrawerPivot? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdNavigationDrawerScope.() -> Unit)? = null
) {
    NavigationDrawerImport // Load the web component

    TagElement("md-navigation-drawer", {
        opened?.let { attr("opened", it) }
        pivot?.let { attr("pivot", it.value) }

        attrs?.invoke(this)
    }, content.toElementScopeContent(::MdNavigationDrawerScope))
}

@MaterialWebLabsApi
@Composable
fun MdNavigationDrawerModal(
    opened: Boolean? = null,
    pivot: NavigationDrawerPivot? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdNavigationDrawerScope.() -> Unit)? = null
) {
    NavigationDrawerModalImport // Load the web component

    TagElement("md-navigation-drawer-modal", {
        opened?.let { attr("opened", it) }
        pivot?.let { attr("pivot", it.value) }

        attrs?.invoke(this)
    }, content.toElementScopeContent(::MdNavigationDrawerScope))
}

class MdNavigationDrawerScope(val elementScope: ElementScope<HTMLElement>) {
    enum class Slot(val value: String) {
        Header("header"), Footer("footer")
    }

    fun AttrsScope<*>.slot(slot: Slot) =
        slot(slot.value)

    fun AttrsScope<*>.slotEqHeader() =
        slot(Slot.Header)

    fun AttrsScope<*>.slotEqFooter() =
        slot(Slot.Footer)
}
