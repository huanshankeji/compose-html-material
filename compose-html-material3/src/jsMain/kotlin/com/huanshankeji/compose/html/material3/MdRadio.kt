package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.ariaLabel
import com.huanshankeji.compose.web.attributes.ext.disabled
import com.huanshankeji.compose.web.attributes.ext.required
import com.huanshankeji.compose.web.attributes.ext.value
import com.varabyte.kobweb.compose.css.role
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/radio.md
https://material-web.dev/components/radio/
https://material-web.dev/components/radio/stories/
https://m3.material.io/components/radio-button/overview
*/

@JsModule("@material/web/radio/radio.js")
private external object RadioImport

@Composable
fun MdRadio(
    required: Boolean? = null,
    value: String? = null,
    checked: Boolean? = null,
    disabled: Boolean? = null,

    // `id` is additionally added for conventional use with `label`.
    id: String? = null,

    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: ContentBuilder<HTMLElement>? = null
) {
    RadioImport // Load the web component

    TagElement("md-radio", {
        required(required)
        value(value)
        attrIfNotNull("checked", checked)
        disabled(disabled)

        id?.let { id(it) }

        attrs?.invoke(this)
    }, content)
}

/**
 * This is an experimental API.
 */
// https://github.com/material-components/material-web/blob/main/radio/demo/stories.ts
@ExperimentalComposeHtmlMaterialApi
fun conventionalRadioGroupAttrs(ariaLabel: String): AttrBuilderContext<*> = {
    role("radiogroup")
    ariaLabel(ariaLabel)
}
