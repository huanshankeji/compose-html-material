package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/divider.md
https://material-web.dev/components/divider/
https://material-web.dev/components/divider/stories/
https://m3.material.io/components/divider/overview
*/

@JsModule("@material/web/divider/divider.js")
private external object DividerImport

@Composable
fun MdDivider(
    inset: Boolean? = null,
    insetStart: Boolean? = null,
    insetEnd: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    DividerImport // Load the web component

    TagElement("md-divider", {
        inset?.let { attr("inset", it) }
        insetStart?.let { attr("inset-start", it) }
        insetEnd?.let { attr("inset-end", it) }

        attrs?.invoke(this)
    }, content)
}
