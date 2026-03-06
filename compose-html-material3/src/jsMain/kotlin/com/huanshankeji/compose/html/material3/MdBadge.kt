package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/badge/internal/badge.ts
https://github.com/material-components/material-web/blob/main/labs/badge/demo/stories.ts
https://m3.material.io/components/badges/overview
*/

@JsModule("@material/web/labs/badge/badge.js")
private external object BadgeImport

@MaterialWebLabsApi
@Composable
fun MdBadge(
    value: String? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: ContentBuilder<HTMLElement>? = null
) {
    BadgeImport // Load the web component

    TagElement("md-badge", {
        attrIfNotNull("value", value)

        attrs?.invoke(this)
    }, content)
}
