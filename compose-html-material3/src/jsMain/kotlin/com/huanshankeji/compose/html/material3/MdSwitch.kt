package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.ext.*
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.TagElement
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/switch.md
https://material-web.dev/components/switch/
https://material-web.dev/components/switch/stories/
*/
@Composable
fun MdSwitch(
    disabled: Boolean? = null,
    selected: Boolean? = null, // `false` won't work here
    icons: Boolean? = null,
    showOnlySelectedIcon: Boolean? = null,
    required: Boolean? = null,
    value: String? = null,
    name: String? = null,
    form: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    require("@material/web/switch/switch.js")

    TagElement("md-switch", {
        disabled(disabled)
        selected?.let { attr("selected", it) }
        icons?.let { attr("icons", it) }
        showOnlySelectedIcon?.let { attr("show-only-selected-icon", it) }
        required(required)
        value(value)
        name(name)
        form(form)

        attrs?.invoke(this)
    }, content)
}

// https://github.com/material-components/material-web/blob/main/docs/components/switch.md#label
@Composable
fun LabelWithMdSwitch(
    label: String,
    disabled: Boolean? = null,
    selected: Boolean? = null,
    icons: Boolean? = null,
    showOnlySelectedIcon: Boolean? = null,
    required: Boolean? = null,
    value: String? = null,
    name: String? = null,
    form: String? = null,
    attrs: Attrs<HTMLElement>? = null
) =
    Label {
        Text(label)
        MdSwitch(disabled, selected, icons, showOnlySelectedIcon, required, value, name, form, attrs)
    }
