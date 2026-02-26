package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.disabled
import com.huanshankeji.compose.web.attributes.ext.label
import com.huanshankeji.compose.web.attributes.ext.required
import com.huanshankeji.compose.web.attributes.ext.value
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/select.md
https://material-web.dev/components/select/
https://material-web.dev/components/select/stories/
https://m3.material.io/components/menus/overview
*/

@JsModule("@material/web/select/filled-select.js")
private external object FilledSelectImport

@JsModule("@material/web/select/outlined-select.js")
private external object OutlinedSelectImport

@JsModule("@material/web/select/select-option.js")
private external object SelectOptionImport

// https://github.com/material-components/material-web/blob/516cbc02bf770b7c3c5c6b546f1e5d81939b9f23/select/internal/select.ts#L134-L135
enum class SelectMenuPositioning(val value: String) {
    Absolute("absolute"), Fixed("fixed"), Popover("popover")
}

enum class SelectMenuAlign(val value: String) {
    Start("start"), End("end")
}

private fun (@Composable MdSelectScope.() -> Unit)?.toElementScopeContentBuilder(): ContentBuilder<HTMLElement>? =
    toElementScopeContentBuilder(::MdSelectScope)

@Composable
private fun CommonSelect(
    tagName: String,
    quick: Boolean?,
    required: Boolean?,
    errorText: String?,
    label: String?,
    noAsterisk: Boolean?,
    supportingText: String?,
    error: Boolean?,
    menuPositioning: SelectMenuPositioning?,
    clampMenuWidth: Boolean?,
    typeaheadDelay: Number?,
    hasLeadingIcon: Boolean?,
    displayText: String?,
    menuAlign: SelectMenuAlign?,
    value: String?,
    selectedIndex: Int?,
    disabled: Boolean?,
    attrs: AttrBuilderContext<HTMLElement>?,
    content: (@Composable MdSelectScope.() -> Unit)?
) =
    TagElement(
        tagName,
        {
            attrIfNotNull("quick", quick)
            required(required)
            attrIfNotNull("error-text", errorText)
            label(label)
            attrIfNotNull("no-asterisk", noAsterisk)
            attrIfNotNull("supporting-text", supportingText)
            attrIfNotNull("error", error)
            attrIfNotNull("menu-positioning", menuPositioning?.value)
            attrIfNotNull("clamp-menu-width", clampMenuWidth)
            attrIfNotNull("typeahead-delay", typeaheadDelay)
            attrIfNotNull("has-leading-icon", hasLeadingIcon)
            attrIfNotNull("display-text", displayText)
            attrIfNotNull("menu-align", menuAlign?.value)
            value(value)
            attrIfNotNull("selected-index", selectedIndex)
            disabled(disabled)

            attrs?.invoke(this)
        },
        content.toElementScopeContentBuilder()
    )

@Composable
fun MdFilledSelect(
    quick: Boolean? = null,
    required: Boolean? = null,
    errorText: String? = null,
    label: String? = null,
    noAsterisk: Boolean? = null,
    supportingText: String? = null,
    error: Boolean? = null,
    menuPositioning: SelectMenuPositioning? = null,
    clampMenuWidth: Boolean? = null,
    typeaheadDelay: Number? = null,
    hasLeadingIcon: Boolean? = null,
    displayText: String? = null,
    menuAlign: SelectMenuAlign? = null,
    value: String? = null,
    selectedIndex: Int? = null,
    disabled: Boolean?,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdSelectScope.() -> Unit)? = null
) {
    FilledSelectImport // Load the web component

    CommonSelect(
        "md-filled-select",
        quick,
        required,
        errorText,
        label,
        noAsterisk,
        supportingText,
        error,
        menuPositioning,
        clampMenuWidth,
        typeaheadDelay,
        hasLeadingIcon,
        displayText,
        menuAlign,
        value,
        selectedIndex,
        disabled,
        attrs,
        content
    )
}

@Composable
fun MdOutlinedSelect(
    quick: Boolean? = null,
    required: Boolean? = null,
    errorText: String? = null,
    label: String? = null,
    noAsterisk: Boolean? = null,
    supportingText: String? = null,
    error: Boolean? = null,
    menuPositioning: SelectMenuPositioning? = null,
    clampMenuWidth: Boolean? = null,
    typeaheadDelay: Number? = null,
    hasLeadingIcon: Boolean? = null,
    displayText: String? = null,
    menuAlign: SelectMenuAlign? = null,
    value: String? = null,
    selectedIndex: Int? = null,
    disabled: Boolean?,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdSelectScope.() -> Unit)? = null
) {
    OutlinedSelectImport // Load the web component

    CommonSelect(
        "md-outlined-select",
        quick,
        required,
        errorText,
        label,
        noAsterisk,
        supportingText,
        error,
        menuPositioning,
        clampMenuWidth,
        typeaheadDelay,
        hasLeadingIcon,
        displayText,
        menuAlign,
        value,
        selectedIndex,
        disabled,
        attrs,
        content
    )
}

class MdSelectScope(val elementScope: ElementScope<HTMLElement>) {
    // https://github.com/search?q=repo%3Amaterial-components%2Fmaterial-web%20path%3A%2F%5Eselect%5C%2F%2F%20trailing-icon&type=code
    enum class Slot(val value: String) {
        LeadingIcon("leading-icon"),
        TrailingIcon("trailing-icon")
    }

    fun AttrsScope<*>.slot(slot: Slot) =
        slot(slot.value)
}

@Composable
fun MdSelectOption(
    disabled: Boolean? = null,
    selected: Boolean? = null,
    value: String? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdSelectOptionScope.() -> Unit)? = null
) {
    SelectOptionImport // Load the web component

    TagElement("md-select-option", {
        disabled(disabled)
        attrIfNotNull("selected", selected)
        value(value)
        // type, typeaheadText, and displayText have no corresponding HTML attribute (property only)

        attrs?.invoke(this)
    }, content?.let {
        { MdSelectOptionScope(this).it() }
    })
}

class MdSelectOptionScope(val elementScope: ElementScope<HTMLElement>) {
    /*
    https://github.com/material-components/material-web/blob/516cbc02bf770b7c3c5c6b546f1e5d81939b9f23/select/internal/selectoption/select-option.ts#L144-L155
    https://github.com/material-components/material-web/blob/516cbc02bf770b7c3c5c6b546f1e5d81939b9f23/select/internal/selectoption/select-option.ts#L214-L224
    */
    enum class Slot(val value: String) {
        Headline("headline"),
        SupportingText("supporting-text"),
        TrailingSupportingText("trailing-supporting-text"),
        Start("start"),
        End("end")
    }

    fun AttrsScope<*>.slot(slot: Slot) =
        slot(slot.value)
}
