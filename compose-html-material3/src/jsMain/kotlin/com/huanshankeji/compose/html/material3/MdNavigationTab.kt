package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.disabled
import com.huanshankeji.compose.web.attributes.ext.label
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/navigationtab/internal/navigation-tab.ts
https://github.com/material-components/material-web/blob/main/labs/navigationbar/demo/stories.ts (navigation bar storybook)
 */

@MaterialWebLabsApi
@Composable
fun MdNavigationTab(
    disabled: Boolean? = null,
    active: Boolean? = null,
    hideInactiveLabel: Boolean? = null,
    label: String? = null,
    badgeValue: String? = null,
    showBadge: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (MdNavigationTabScope.() -> Unit)?
) {
    require("@material/web/labs/navigationtab/navigation-tab.js")

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
    enum class Slot(val stringValue: String) {
        ActiveIcon("active-icon"), InactiveIcon("inactive-icon")
    }

    fun AttrsScope<*>.slot(value: Slot) =
        slot(value.stringValue)
}
