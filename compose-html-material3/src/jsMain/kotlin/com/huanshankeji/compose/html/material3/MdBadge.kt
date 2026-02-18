package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/badge/internal/badge.ts
https://github.com/material-components/material-web/blob/main/labs/badge/demo/stories.ts
*/

@JsModule("@material/web/labs/badge/badge.js")
private external object BadgeImport

@MaterialWebLabsApi
@Composable
fun MdBadge(
    value: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    BadgeImport // Load the web component

    TagElement("md-badge", {
        value?.let { attr("value", it) }

        attrs?.invoke(this)
    }, content)
}
