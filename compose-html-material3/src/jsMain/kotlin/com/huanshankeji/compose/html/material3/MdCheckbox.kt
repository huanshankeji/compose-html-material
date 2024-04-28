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
    name: String? = null,
    form: String? = null,
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
        name(name)
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
    name: String? = null,
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

    MdCheckbox(checked, disabled, indeterminate, required, value, name, form, attrs)
}
