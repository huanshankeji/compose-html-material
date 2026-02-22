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
https://github.com/material-components/material-web/blob/main/docs/components/chips.md
https://material-web.dev/components/chips/
https://material-web.dev/components/chips/stories/
https://m3.material.io/components/chips/overview
*/

@JsModule("@material/web/chips/assist-chip.js")
private external object AssistChipImport

@JsModule("@material/web/chips/filter-chip.js")
private external object FilterChipImport

@JsModule("@material/web/chips/input-chip.js")
private external object InputChipImport

@JsModule("@material/web/chips/suggestion-chip.js")
private external object SuggestionChipImport

@JsModule("@material/web/chips/chip-set.js")
private external object ChipSetImport

private fun commonChipAttrs(
    disabled: Boolean?,
    elevated: Boolean?,
    href: String?,
    target: String?,
    label: String?,
    alwaysFocusable: Boolean?,
    attrs: Attrs<HTMLElement>?
): Attrs<HTMLElement> =
    {
        disabled(disabled)
        elevated?.let { attr("elevated", it) }
        href(href)
        target(target)
        label(label)
        alwaysFocusable?.let { attr("always-focusable", it) }

        attrs?.invoke(this)
    }

private fun <T> (@Composable T.() -> Unit)?.toElementScopeContent(
    scopeFactory: (ElementScope<HTMLElement>) -> T
): (@Composable ElementScope<HTMLElement>.() -> Unit)? =
    this?.let {
        { scopeFactory(this).it() }
    }

@Composable
private fun CommonChip(
    tagName: String,
    disabled: Boolean?,
    elevated: Boolean?,
    href: String?,
    target: String?,
    label: String?,
    alwaysFocusable: Boolean?,
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdChipScope.() -> Unit)?
) =
    TagElement(
        tagName,
        commonChipAttrs(disabled, elevated, href, target, label, alwaysFocusable, attrs),
        content.toElementScopeContent(::MdChipScope)
    )

@Composable
fun MdAssistChip(
    disabled: Boolean? = null,
    elevated: Boolean? = null,
    href: String? = null,
    target: String? = null,
    label: String? = null,
    alwaysFocusable: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdChipScope.() -> Unit)? = null
) {
    AssistChipImport // Load the web component

    CommonChip(
        "md-assist-chip",
        disabled, elevated, href, target, label, alwaysFocusable, attrs, content
    )
}

@Composable
fun MdFilterChip(
    disabled: Boolean? = null,
    elevated: Boolean? = null,
    removable: Boolean? = null,
    selected: Boolean? = null,
    label: String? = null,
    alwaysFocusable: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdChipScope.() -> Unit)? = null
) {
    FilterChipImport // Load the web component

    TagElement("md-filter-chip", {
        disabled(disabled)
        elevated?.let { attr("elevated", it) }
        removable?.let { attr("removable", it) }
        selected?.let { attr("selected", it) }
        label(label)
        alwaysFocusable?.let { attr("always-focusable", it) }

        attrs?.invoke(this)
    }, content.toElementScopeContent(::MdChipScope))
}

@Composable
fun MdInputChip(
    disabled: Boolean? = null,
    avatar: Boolean? = null,
    href: String? = null,
    target: String? = null,
    removeOnly: Boolean? = null,
    selected: Boolean? = null,
    label: String? = null,
    alwaysFocusable: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdInputChipScope.() -> Unit)? = null
) {
    InputChipImport // Load the web component

    TagElement("md-input-chip", {
        disabled(disabled)
        avatar?.let { attr("avatar", it) }
        href(href)
        target(target)
        removeOnly?.let { attr("remove-only", it) }
        selected?.let { attr("selected", it) }
        label(label)
        alwaysFocusable?.let { attr("always-focusable", it) }

        attrs?.invoke(this)
    }, content.toElementScopeContent(::MdInputChipScope))
}

@Composable
fun MdSuggestionChip(
    disabled: Boolean? = null,
    elevated: Boolean? = null,
    href: String? = null,
    target: String? = null,
    label: String? = null,
    alwaysFocusable: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdChipScope.() -> Unit)? = null
) {
    SuggestionChipImport // Load the web component

    CommonChip(
        "md-suggestion-chip",
        disabled, elevated, href, target, label, alwaysFocusable, attrs, content
    )
}

@Composable
fun MdChipSet(
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    ChipSetImport // Load the web component

    TagElement("md-chip-set", {
        attrs?.invoke(this)
    }, content)
}

open class MdChipScope(val elementScope: ElementScope<HTMLElement>) {
    enum class Slot(val value: String) {
        Icon("icon")
    }

    fun AttrsScope<*>.slot(slot: Slot) =
        slot(slot.value)

    fun AttrsScope<*>.slotEqIcon() =
        slot(Slot.Icon)
}

class MdInputChipScope(elementScope: ElementScope<HTMLElement>) : MdChipScope(elementScope) {
    enum class InputChipSlot(val value: String) {
        TrailingIcon("trailing-icon")
    }

    fun AttrsScope<*>.slot(slot: InputChipSlot) =
        slot(slot.value)

    fun AttrsScope<*>.slotEqTrailingIcon() =
        slot(InputChipSlot.TrailingIcon)
}
