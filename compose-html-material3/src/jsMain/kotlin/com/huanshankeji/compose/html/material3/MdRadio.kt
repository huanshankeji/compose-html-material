package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.ext.*
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/radio.md
https://material-web.dev/components/radio/
https://material-web.dev/components/radio/stories/
*/

@JsModule("@material/web/radio/radio.js")
private external object RadioImport

@Composable
fun MdRadio(
    checked: Boolean? = null,
    disabled: Boolean? = null,
    required: Boolean? = null,
    value: String? = null,
    name: String? = null,
    form: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    RadioImport // Load the web component

    TagElement("md-radio", {
        checked?.let { attr("checked", it) }
        disabled(disabled)
        required(required)
        value(value)
        name(name)
        form(form)

        attrs?.invoke(this)
    }, content)
}
