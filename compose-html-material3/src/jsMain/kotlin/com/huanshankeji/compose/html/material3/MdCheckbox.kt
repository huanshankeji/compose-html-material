package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.*
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/checkbox.md
https://material-web.dev/components/checkbox/
https://material-web.dev/components/checkbox/stories/
*/
@Composable
fun MdCheckbox(
    checked: Boolean? = null,
    disabled: Boolean? = null,
    indeterminate: Boolean? = null,
    required: Boolean? = null,
    value: String? = null,
    form: String? = null,
    //labels : NodeList? = null, // This is a read-only property. See https://developer.mozilla.org/en-US/docs/Web/API/HTMLInputElement/labels.
    //validity : ValidityState? = null, // This is a read-only property. See https://developer.mozilla.org/en-US/docs/Web/API/HTMLObjectElement/validity.
    //validationMessage : String? = null, // This is a read-only property. See https://developer.mozilla.org/en-US/docs/Web/API/HTMLObjectElement/validationMessage.
    //willValidate : Boolean? = null, // This is a read-only property. See https://developer.mozilla.org/en-US/docs/Web/API/HTMLObjectElement/willValidate.
    attrs: Attrs<HTMLElement>? = null
) {
    require("@material/web/checkbox/checkbox.js")

    TagElement("md-checkbox", {
        attr("touch-target", "wrapper")
        checked?.let { attr("checked", it) }
        disabled(disabled)
        indeterminate?.let { attr("indeterminate", it) }
        required(required)
        value(value)
        form(form)
        attrs?.invoke(this)
    }, null)
}


enum class MdCheckboxState {
    Unchecked, Checked, Indeterminate
}

@Composable
fun MdCheckbox(
    state: MdCheckboxState,
    disabled: Boolean? = null,
    required: Boolean? = null,
    value: String? = null,
    form: String? = null,
    attrs: Attrs<HTMLElement>? = null
) {
    val checked: Boolean?
    val indeterminate: Boolean?
    when (state) {
        MdCheckboxState.Unchecked -> {
            checked = null
            indeterminate = null
        }

        MdCheckboxState.Checked -> {
            checked = true
            indeterminate = null
        }

        MdCheckboxState.Indeterminate -> {
            checked = null
            indeterminate = true
        }
    }

    MdCheckbox(checked, disabled, indeterminate, required, value, form, attrs)
}
