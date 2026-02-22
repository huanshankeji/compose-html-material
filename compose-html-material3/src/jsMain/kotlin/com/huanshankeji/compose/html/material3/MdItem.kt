package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/item/internal/item.ts
https://github.com/material-components/material-web/blob/main/labs/item/demo/stories.ts
https://github.com/material-components/material-web/blob/main/labs/item/README.md
*/

@JsModule("@material/web/labs/item/item.js")
private external object ItemImport

@MaterialWebLabsApi
@Composable
fun MdItem(
    multiline: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    ItemImport // Load the web component

    TagElement("md-item", {
        multiline?.let { attr("multiline", it) }

        attrs?.invoke(this)
    }, content)
}
