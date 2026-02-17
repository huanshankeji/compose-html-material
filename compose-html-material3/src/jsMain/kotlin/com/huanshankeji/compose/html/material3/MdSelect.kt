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
https://github.com/material-components/material-web/blob/main/docs/components/select.md
https://material-web.dev/components/select/
https://material-web.dev/components/select/stories/
*/

@JsModule("@material/web/select/filled-select.js")
private external object FilledSelectImport

@JsModule("@material/web/select/outlined-select.js")
private external object OutlinedSelectImport

@JsModule("@material/web/select/select-option.js")
private external object SelectOptionImport

private fun commonSelectAttrs(
    disabled: Boolean?,
    required: Boolean?,
    errorText: String?,
    label: String?,
    supportingText: String?,
    error: Boolean?,
    menuPositioning: String?,
    clampMenuWidth: Boolean?,
    quick: Boolean?,
    displayText: String?,
    menuAlign: String?,
    value: String?,
    selectedIndex: Int?,
    name: String?,
    form: String?,
    attrs: Attrs<HTMLElement>?
): Attrs<HTMLElement> =
    {
        disabled(disabled)
        required(required)
        errorText?.let { attr("error-text", it) }
        label(label)
        supportingText?.let { attr("supporting-text", it) }
        error?.let { attr("error", it) }
        menuPositioning?.let { attr("menu-positioning", it) }
        clampMenuWidth?.let { attr("clamp-menu-width", it) }
        quick?.let { attr("quick", it) }
        displayText?.let { attr("display-text", it) }
        menuAlign?.let { attr("menu-align", it) }
        value(value)
        selectedIndex?.let { attr("selected-index", it.toString()) }
        name(name)
        form(form)

        attrs?.invoke(this)
    }

private fun (@Composable MdSelectScope.() -> Unit)?.toElementScopeContent(): (@Composable ElementScope<HTMLElement>.() -> Unit)? =
    this?.let {
        { MdSelectScope(this).it() }
    }

@Composable
private fun CommonSelect(
    tagName: String,
    disabled: Boolean?,
    required: Boolean?,
    errorText: String?,
    label: String?,
    supportingText: String?,
    error: Boolean?,
    menuPositioning: String?,
    clampMenuWidth: Boolean?,
    quick: Boolean?,
    displayText: String?,
    menuAlign: String?,
    value: String?,
    selectedIndex: Int?,
    name: String?,
    form: String?,
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdSelectScope.() -> Unit)?
) =
    TagElement(
        tagName,
        commonSelectAttrs(
            disabled, required, errorText, label, supportingText, error,
            menuPositioning, clampMenuWidth, quick, displayText, menuAlign,
            value, selectedIndex, name, form, attrs
        ),
        content.toElementScopeContent()
    )

@Composable
fun MdFilledSelect(
    disabled: Boolean? = null,
    required: Boolean? = null,
    errorText: String? = null,
    label: String? = null,
    supportingText: String? = null,
    error: Boolean? = null,
    menuPositioning: String? = null,
    clampMenuWidth: Boolean? = null,
    quick: Boolean? = null,
    displayText: String? = null,
    menuAlign: String? = null,
    value: String? = null,
    selectedIndex: Int? = null,
    name: String? = null,
    form: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdSelectScope.() -> Unit)? = null
) {
    FilledSelectImport // Load the web component

    CommonSelect(
        "md-filled-select",
        disabled, required, errorText, label, supportingText, error,
        menuPositioning, clampMenuWidth, quick, displayText, menuAlign,
        value, selectedIndex, name, form, attrs, content
    )
}

@Composable
fun MdOutlinedSelect(
    disabled: Boolean? = null,
    required: Boolean? = null,
    errorText: String? = null,
    label: String? = null,
    supportingText: String? = null,
    error: Boolean? = null,
    menuPositioning: String? = null,
    clampMenuWidth: Boolean? = null,
    quick: Boolean? = null,
    displayText: String? = null,
    menuAlign: String? = null,
    value: String? = null,
    selectedIndex: Int? = null,
    name: String? = null,
    form: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdSelectScope.() -> Unit)? = null
) {
    OutlinedSelectImport // Load the web component

    CommonSelect(
        "md-outlined-select",
        disabled, required, errorText, label, supportingText, error,
        menuPositioning, clampMenuWidth, quick, displayText, menuAlign,
        value, selectedIndex, name, form, attrs, content
    )
}

@Composable
fun MdSelectOption(
    disabled: Boolean? = null,
    selected: Boolean? = null,
    value: String? = null,
    type: String? = null,
    displayText: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdSelectOptionScope.() -> Unit)? = null
) {
    SelectOptionImport // Load the web component

    TagElement("md-select-option", {
        disabled(disabled)
        selected?.let { attr("selected", it) }
        value(value)
        type(type)
        displayText?.let { attr("display-text", it) }

        attrs?.invoke(this)
    }, content?.let {
        { MdSelectOptionScope(this).it() }
    })
}

class MdSelectScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqLeadingIcon() =
        slot("leading-icon")
}

class MdSelectOptionScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqStart() =
        slot("start")

    fun AttrsScope<*>.slotEqEnd() =
        slot("end")
}
