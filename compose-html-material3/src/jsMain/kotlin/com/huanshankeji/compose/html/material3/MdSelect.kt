package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.ext.disabled
import com.huanshankeji.compose.web.attributes.ext.label
import com.huanshankeji.compose.web.attributes.ext.required
import com.huanshankeji.compose.web.attributes.ext.value
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
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

private fun (@Composable MdSelectScope.() -> Unit)?.toElementScopeContent(): (@Composable ElementScope<HTMLElement>.() -> Unit)? =
    this?.let { { MdSelectScope(this).it() } }

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
    menuPositioning: String?,
    clampMenuWidth: Boolean?,
    typeaheadDelay: Number?,
    hasLeadingIcon: Boolean?,
    displayText: String?,
    menuAlign: String?,
    value: String?,
    selectedIndex: Int?,
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdSelectScope.() -> Unit)?
) =
    TagElement(
        tagName,
        {
            quick?.let { attr("quick", it) }
            required(required)
            errorText?.let { attr("error-text", it) }
            label(label)
            noAsterisk?.let { attr("no-asterisk", it) }
            supportingText?.let { attr("supporting-text", it) }
            error?.let { attr("error", it) }
            menuPositioning?.let { attr("menu-positioning", it) }
            clampMenuWidth?.let { attr("clamp-menu-width", it) }
            typeaheadDelay?.let { attr("typeahead-delay", it) }
            hasLeadingIcon?.let { attr("has-leading-icon", it) }
            displayText?.let { attr("display-text", it) }
            menuAlign?.let { attr("menu-align", it) }
            value(value)
            selectedIndex?.let { attr("selected-index", it) }

            attrs?.invoke(this)
        },
        content.toElementScopeContent()
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
    menuPositioning: String? = null,
    clampMenuWidth: Boolean? = null,
    typeaheadDelay: Number? = null,
    hasLeadingIcon: Boolean? = null,
    displayText: String? = null,
    menuAlign: String? = null,
    value: String? = null,
    selectedIndex: Int? = null,
    attrs: Attrs<HTMLElement>? = null,
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
    menuPositioning: String? = null,
    clampMenuWidth: Boolean? = null,
    typeaheadDelay: Number? = null,
    hasLeadingIcon: Boolean? = null,
    displayText: String? = null,
    menuAlign: String? = null,
    value: String? = null,
    selectedIndex: Int? = null,
    attrs: Attrs<HTMLElement>? = null,
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
        attrs,
        content
    )
}

class MdSelectScope(val elementScope: ElementScope<HTMLElement>) {
    // TODO `leading-icon` and `trailing-icon`. Use enums.
    fun AttrsScope<*>.slotEqLeadingIcon() =
        slot("leading-icon")
}

@Composable
fun MdSelectOption(
    disabled: Boolean? = null,
    selected: Boolean? = null,
    value: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdSelectOptionScope.() -> Unit)? = null
) {
    SelectOptionImport // Load the web component

    TagElement("md-select-option", {
        disabled(disabled)
        selected?.let { attr("selected", it) }
        value(value)
        // type, typeaheadText, and displayText have no corresponding HTML attribute (property only)

        attrs?.invoke(this)
    }, content?.let {
        { MdSelectOptionScope(this).it() }
    })
}

class MdSelectOptionScope(val elementScope: ElementScope<HTMLElement>) {
    // TODO There may be other slot values.

    fun AttrsScope<*>.slotEqHeadline() =
        slot("headline")
}
