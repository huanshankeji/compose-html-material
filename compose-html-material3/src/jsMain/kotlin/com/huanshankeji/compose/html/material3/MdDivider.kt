package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
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
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: ContentBuilder<HTMLElement>? = null
) {
    DividerImport // Load the web component

    TagElement("md-divider", {
        attrIfNotNull("inset", inset)
        attrIfNotNull("inset-start", insetStart)
        attrIfNotNull("inset-end", insetEnd)

        attrs?.invoke(this)
    }, content)
}
