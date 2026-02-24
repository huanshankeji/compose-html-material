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
https://github.com/material-components/material-web/blob/main/docs/components/chip.md
https://material-web.dev/components/chip/
https://material-web.dev/components/chip/stories/
https://m3.material.io/components/chips/overview
*/

@JsModule("@material/web/chips/chip-set.js")
private external object ChipSetImport

@JsModule("@material/web/chips/assist-chip.js")
private external object AssistChipImport

@JsModule("@material/web/chips/filter-chip.js")
private external object FilterChipImport

@JsModule("@material/web/chips/input-chip.js")
private external object InputChipImport

@JsModule("@material/web/chips/suggestion-chip.js")
private external object SuggestionChipImport

@Composable
fun MdChipSet(
    attrs: Attrs<HTMLElement>? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    ChipSetImport // Load the web component

    TagElement("md-chip-set", {
        ariaLabel(ariaLabel)
        ariaLabelledBy(ariaLabelledBy)

        attrs?.invoke(this)
    }, content)
}

private fun (@Composable MdChipScope.() -> Unit)?.toElementScopeContent(): (@Composable ElementScope<HTMLElement>.() -> Unit)? =
    this?.let { { MdChipScope(this).it() } }

@Composable
private fun CommonMdAssistAndMdSuggestionChip(
    tagName: String,
    elevated: Boolean?,
    href: String?,
    download: String?,
    target: String?,
    disabled: Boolean?,
    softDisabled: Boolean?,
    alwaysFocusable: Boolean?,
    label: String?,
    hasIcon: Boolean?,
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdChipScope.() -> Unit)?
) =
    TagElement(
        tagName,
        {
            elevated?.let { attr("elevated", it) }
            href(href)
            download(download)
            target(target)
            disabled(disabled)
            softDisabled?.let { attr("soft-disabled", it) }
            alwaysFocusable?.let { attr("always-focusable", it) }
            label(label)
            hasIcon?.let { attr("has-icon", it) }

            attrs?.invoke(this)
        },
        content.toElementScopeContent()
    )

@Composable
fun MdAssistChip(
    elevated: Boolean? = null,
    href: String? = null,
    download: String? = null,
    target: String? = null,
    disabled: Boolean? = null,
    softDisabled: Boolean? = null,
    alwaysFocusable: Boolean? = null,
    label: String? = null,
    hasIcon: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdChipScope.() -> Unit)? = null
) {
    AssistChipImport // Load the web component

    CommonMdAssistAndMdSuggestionChip(
        "md-assist-chip",
        elevated, href, download, target, disabled, softDisabled, alwaysFocusable, label, hasIcon, attrs, content
    )
}

@Composable
fun MdFilterChip(
    elevated: Boolean? = null,
    removable: Boolean? = null,
    selected: Boolean? = null,
    hasSelectedIcon: Boolean? = null,
    disabled: Boolean? = null,
    softDisabled: Boolean? = null,
    alwaysFocusable: Boolean? = null,
    label: String? = null,
    hasIcon: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdChipScope.() -> Unit)? = null
) {
    FilterChipImport // Load the web component

    TagElement("md-filter-chip", {
        elevated?.let { attr("elevated", it) }
        removable?.let { attr("removable", it) }
        selected?.let { attr("selected", it) }
        hasSelectedIcon?.let { attr("has-selected-icon", it) }
        disabled(disabled)
        softDisabled?.let { attr("soft-disabled", it) }
        alwaysFocusable?.let { attr("always-focusable", it) }
        label(label)
        hasIcon?.let { attr("has-icon", it) }

        attrs?.invoke(this)
    }, content.toElementScopeContent())
}

@Composable
fun MdInputChip(
    avatar: Boolean? = null,
    href: String? = null,
    target: String? = null,
    removeOnly: Boolean? = null,
    selected: Boolean? = null,
    disabled: Boolean? = null,
    softDisabled: Boolean? = null,
    alwaysFocusable: Boolean? = null,
    label: String? = null,
    hasIcon: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdChipScope.() -> Unit)? = null
) {
    InputChipImport // Load the web component

    TagElement("md-input-chip", {
        avatar?.let { attr("avatar", it) }
        href(href)
        target(target)
        removeOnly?.let { attr("remove-only", it) }
        selected?.let { attr("selected", it) }
        disabled(disabled)
        softDisabled?.let { attr("soft-disabled", it) }
        alwaysFocusable?.let { attr("always-focusable", it) }
        label(label)
        hasIcon?.let { attr("has-icon", it) }

        attrs?.invoke(this)
    }, content.toElementScopeContent())
}

@Composable
fun MdSuggestionChip(
    elevated: Boolean? = null,
    href: String? = null,
    download: String? = null,
    target: String? = null,
    disabled: Boolean? = null,
    softDisabled: Boolean? = null,
    alwaysFocusable: Boolean? = null,
    label: String? = null,
    hasIcon: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdChipScope.() -> Unit)? = null
) {
    SuggestionChipImport // Load the web component

    CommonMdAssistAndMdSuggestionChip(
        "md-suggestion-chip",
        elevated, href, download, target, disabled, softDisabled, alwaysFocusable, label, hasIcon, attrs, content
    )
}

class MdChipScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqIcon() =
        slot("icon")
}
