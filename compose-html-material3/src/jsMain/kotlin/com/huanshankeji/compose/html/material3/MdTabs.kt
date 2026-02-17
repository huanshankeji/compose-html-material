package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.ext.*
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/tabs.md
https://material-web.dev/components/tabs/
https://material-web.dev/components/tabs/stories/
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
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    TabsImport // Load the web component

    TagElement("md-tabs", {
        autoActivate?.let { attr("auto-activate", it) }
        activeTabIndex?.let { attr("active-tab-index", it.toString()) }

        attrs?.invoke(this)
    }, content)
}

private fun commonTabAttrs(
    disabled: Boolean?,
    active: Boolean?,
    hasIcon: Boolean?,
    iconOnly: Boolean?,
    selected: Boolean?,
    inlineIcon: Boolean?,
    attrs: Attrs<HTMLElement>?
): Attrs<HTMLElement> =
    {
        disabled(disabled)
        active?.let { attr("active", it) }
        hasIcon?.let { attr("has-icon", it) }
        iconOnly?.let { attr("icon-only", it) }
        selected?.let { attr("selected", it) }
        inlineIcon?.let { attr("inline-icon", it) }

        attrs?.invoke(this)
    }

private fun (@Composable MdTabScope.() -> Unit)?.toElementScopeContent(): (@Composable ElementScope<HTMLElement>.() -> Unit)? =
    this?.let {
        { MdTabScope(this).it() }
    }

@Composable
private fun CommonTab(
    tagName: String,
    disabled: Boolean?,
    active: Boolean?,
    hasIcon: Boolean?,
    iconOnly: Boolean?,
    selected: Boolean?,
    inlineIcon: Boolean?,
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdTabScope.() -> Unit)?
) =
    TagElement(
        tagName,
        commonTabAttrs(disabled, active, hasIcon, iconOnly, selected, inlineIcon, attrs),
        content.toElementScopeContent()
    )

@Composable
fun MdPrimaryTab(
    disabled: Boolean? = null,
    active: Boolean? = null,
    hasIcon: Boolean? = null,
    iconOnly: Boolean? = null,
    selected: Boolean? = null,
    inlineIcon: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdTabScope.() -> Unit)? = null
) {
    PrimaryTabImport // Load the web component

    CommonTab(
        "md-primary-tab",
        disabled, active, hasIcon, iconOnly, selected, inlineIcon, attrs, content
    )
}

@Composable
fun MdSecondaryTab(
    disabled: Boolean? = null,
    active: Boolean? = null,
    hasIcon: Boolean? = null,
    iconOnly: Boolean? = null,
    selected: Boolean? = null,
    inlineIcon: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdTabScope.() -> Unit)? = null
) {
    SecondaryTabImport // Load the web component

    CommonTab(
        "md-secondary-tab",
        disabled, active, hasIcon, iconOnly, selected, inlineIcon, attrs, content
    )
}

class MdTabScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqIcon() =
        slot("icon")
}
