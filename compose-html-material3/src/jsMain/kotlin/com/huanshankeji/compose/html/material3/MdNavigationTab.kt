package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.disabled
import com.huanshankeji.compose.web.attributes.ext.label
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/navigationtab/internal/navigation-tab.ts
https://github.com/material-components/material-web/blob/main/labs/navigationbar/demo/stories.ts (navigation bar storybook)
https://material-web.dev/components/navigation-bar/
https://m3.material.io/components/navigation-bar/overview
 */

@JsModule("@material/web/labs/navigationtab/navigation-tab.js")
private external object NavigationTabImport

@MaterialWebLabsApi
@Composable
fun MdNavigationTab(
    disabled: Boolean? = null,
    active: Boolean? = null,
    hideInactiveLabel: Boolean? = null,
    label: String? = null,
    badgeValue: String? = null,
    showBadge: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable (MdNavigationTabScope.() -> Unit)?
) {
    NavigationTabImport // Load the web component

    TagElement("md-navigation-tab", {
        disabled(disabled)
        attrIfNotNull("active", active)
        attrIfNotNull("hide-inactive-label", hideInactiveLabel)
        label(label)
        attrIfNotNull("badge-value", badgeValue)
        attrIfNotNull("show-badge", showBadge)

        attrs?.invoke(this)
    }, content?.let { { MdNavigationTabScope(this).it() } })
}

class MdNavigationTabScope(val elementScope: ElementScope<HTMLElement>) {
    // https://github.com/search?q=repo%3Amaterial-components%2Fmaterial-web%20path%3A%2F%5Elabs%5C%2Fnavigationtab%5C%2F%2F%20active-icon&type=code
    enum class Slot(val value: String) {
        ActiveIcon("active-icon"), InactiveIcon("inactive-icon")
    }

    fun AttrsScope<*>.slot(slot: Slot) =
        slot(slot.value)
}
