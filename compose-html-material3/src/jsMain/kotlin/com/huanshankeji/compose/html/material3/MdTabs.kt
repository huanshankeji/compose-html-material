package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/tabs.md
https://material-web.dev/components/tabs/
https://material-web.dev/components/tabs/stories/
https://m3.material.io/components/tabs/overview
*/

@JsModule("@material/web/tabs/tabs.js")
private external object TabsImport

@JsModule("@material/web/tabs/primary-tab.js")
private external object PrimaryTabImport

@JsModule("@material/web/tabs/secondary-tab.js")
private external object SecondaryTabImport

@Composable
fun MdTabs(
    autoActivate: Boolean? = null,
    activeTabIndex: Int? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: ContentBuilder<HTMLElement>? = null
) {
    TabsImport // Load the web component

    TagElement("md-tabs", {
        attrIfNotNull("auto-activate", autoActivate)
        attrIfNotNull("active-tab-index", activeTabIndex)

        attrs?.invoke(this)
    }, content)
}

private fun (@Composable MdTabScope.() -> Unit)?.toElementScopeContentBuilder(): ContentBuilder<HTMLElement>? =
    toElementScopeContentBuilder(::MdTabScope)

@Composable
private fun CommonTab(
    tagName: String,
    inlineIcon: Boolean?,
    isTab: Boolean?,
    active: Boolean?,
    hasIcon: Boolean?,
    iconOnly: Boolean?,
    selected: Boolean?,

    // https://github.com/material-components/material-web/blob/main/docs/components/tabs.md#tab-panels
    id: String?,
    ariaControls: String?,

    attrs: AttrBuilderContext<HTMLElement>?,
    content: (@Composable MdTabScope.() -> Unit)?
) =
    TagElement(
        tagName,
        {
            attrIfNotNull("inline-icon", inlineIcon)
            attrIfNotNull("md-tab", isTab)
            attrIfNotNull("active", active)
            attrIfNotNull("has-icon", hasIcon)
            attrIfNotNull("icon-only", iconOnly)
            attrIfNotNull("selected", selected)

            id?.let { id(it) }
            attrIfNotNull("aria-controls", ariaControls)

            attrs?.invoke(this)
        },
        content.toElementScopeContentBuilder()
    )

@Composable
fun MdPrimaryTab(
    inlineIcon: Boolean? = null,
    isTab: Boolean? = null,
    active: Boolean? = null,
    hasIcon: Boolean? = null,
    iconOnly: Boolean? = null,
    selected: Boolean? = null,

    id: String? = null,
    ariaControls: String? = null,

    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdTabScope.() -> Unit)? = null
) {
    PrimaryTabImport // Load the web component

    CommonTab(
        "md-primary-tab",
        inlineIcon, isTab, active, hasIcon, iconOnly, selected, id, ariaControls, attrs, content
    )
}

@Composable
fun MdSecondaryTab(
    isTab: Boolean? = null,
    active: Boolean? = null,
    hasIcon: Boolean? = null,
    iconOnly: Boolean? = null,
    selected: Boolean? = null,

    id: String? = null,
    ariaControls: String? = null,

    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdTabScope.() -> Unit)? = null
) {
    SecondaryTabImport // Load the web component

    CommonTab(
        "md-secondary-tab",
        null, isTab, active, hasIcon, iconOnly, selected, id, ariaControls, attrs, content
    )
}

class MdTabScope(val elementScope: ElementScope<HTMLElement>) : SlotScope<MdTabScope.Slot> {
    enum class Slot(override val value: String) : ISlot {
        Icon("icon")
    }
}
