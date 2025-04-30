package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.ext.*
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.AutoComplete
import org.jetbrains.compose.web.attributes.InputMode
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/text-field.md
https://material-web.dev/components/text-field/
https://material-web.dev/components/text-field/stories/
*/

@Composable
private fun CommonTextField(
    tagName: String,
    disabled: Boolean?,
    error: Boolean?,
    errorText: String?,
    label: String?, // This attribute seems to have different semantics here from its original semantics in HTML.
    required: Boolean?,
    value: String?,
    prefixText: String?,
    suffixText: String?,
    hasLeadingIcon: Boolean?,
    hasTrailingIcon: Boolean?,
    supportingText: String?,
    textDirection: String?,
    rows: Int?, // The JavaScript `number` is actually a `Double`. See https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number.
    cols: Int?,
    inputMode: InputMode?,
    max: String?,
    maxLength: Int?,
    min: String?,
    minLength: Int?,
    pattern: String?,
    placeholder: String?,
    readOnly: Boolean?,
    multiple: Boolean?,
    step: String?,
    type: InputType<*>?,
    autocomplete: AutoComplete?,
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdTextFieldScope.() -> Unit)?
) =
    TagElement(tagName, {
        disabled(disabled)
        error?.let { attr("error", it) }
        errorText?.let { attr("error-text", it) }
        label(label)
        required(required)
        value(value)
        prefixText?.let { attr("prefix-text", it) }
        suffixText?.let { attr("suffix-text", it) }
        hasLeadingIcon?.let { attr("has-leading-icon", it) }
        hasTrailingIcon?.let { attr("has-trailing-icon", it) }
        supportingText?.let { attr("supporting-text", it) }
        textDirection?.let { attr("text-direction", it) }
        rows?.let { attr("rows", it) }
        cols?.let { attr("cols", it) }
        inputMode?.let { inputMode(it) }
        max(max)
        maxLength(maxLength)
        min(min)
        minLength(minLength)
        pattern(pattern)
        placeholder(placeholder)
        readOnly(readOnly)
        multiple(multiple)
        step(step)
        type(type)
        autoComplete(autocomplete)

        attrs?.invoke(this)
    }, content?.let { { MdTextFieldScope(this).it() } })

@Composable
fun MdFilledTextField(
    disabled: Boolean? = null,
    error: Boolean? = null,
    errorText: String? = null,
    label: String? = null,
    required: Boolean? = null,
    value: String? = null,
    prefixText: String? = null,
    suffixText: String? = null,
    hasLeadingIcon: Boolean? = null,
    hasTrailingIcon: Boolean? = null,
    supportingText: String? = null,
    textDirection: String? = null,
    rows: Int? = null,
    cols: Int? = null,
    inputMode: InputMode? = null,
    max: String? = null,
    maxLength: Int? = null,
    min: String? = null,
    minLength: Int? = null,
    pattern: String? = null,
    placeholder: String? = null,
    readOnly: Boolean? = null,
    multiple: Boolean? = null,
    step: String? = null,
    type: InputType<*>? = null,
    autocomplete: AutoComplete? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdTextFieldScope.() -> Unit)? = null
) {
    require("@material/web/textfield/filled-text-field.js")

    CommonTextField(
        "md-filled-text-field",
        disabled,
        error,
        errorText,
        label,
        required,
        value,
        prefixText,
        suffixText,
        hasLeadingIcon,
        hasTrailingIcon,
        supportingText,
        textDirection,
        rows,
        cols,
        inputMode,
        max,
        maxLength,
        min,
        minLength,
        pattern,
        placeholder,
        readOnly,
        multiple,
        step,
        type,
        autocomplete,
        attrs,
        content
    )
}

@Composable
fun MdOutlinedTextField(
    disabled: Boolean? = null,
    error: Boolean? = null,
    errorText: String? = null,
    label: String? = null,
    required: Boolean? = null,
    value: String? = null,
    prefixText: String? = null,
    suffixText: String? = null,
    hasLeadingIcon: Boolean? = null,
    hasTrailingIcon: Boolean? = null,
    supportingText: String? = null,
    textDirection: String? = null,
    rows: Int? = null,
    cols: Int? = null,
    inputMode: InputMode? = null,
    max: String? = null,
    maxLength: Int? = null,
    min: String? = null,
    minLength: Int? = null,
    pattern: String? = null,
    placeholder: String? = null,
    readOnly: Boolean? = null,
    multiple: Boolean? = null,
    step: String? = null,
    type: InputType<*>? = null,
    autocomplete: AutoComplete? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdTextFieldScope.() -> Unit)? = null
) {
    require("@material/web/textfield/outlined-text-field.js")

    CommonTextField(
        "md-outlined-text-field",
        disabled,
        error,
        errorText,
        label,
        required,
        value,
        prefixText,
        suffixText,
        hasLeadingIcon,
        hasTrailingIcon,
        supportingText,
        textDirection,
        rows,
        cols,
        inputMode,
        max,
        maxLength,
        min,
        minLength,
        pattern,
        placeholder,
        readOnly,
        multiple,
        step,
        type,
        autocomplete,
        attrs,
        content
    )
}


class MdTextFieldScope(val elementScope: ElementScope<HTMLElement>) {
    enum class Slot(val value: String) {
        LeadingIcon("leading-icon"), TrailingIcon("trailing-icon")
    }

    fun AttrsScope<*>.slot(value: Slot) =
        slot(value.value)
}

object TextareaInputType : InputType.InputTypeWithStringValue("textarea")
