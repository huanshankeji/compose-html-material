package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/segmentedbuttonset/internal/segmented-button-set.ts
https://github.com/material-components/material-web/blob/main/labs/segmentedbuttonset/demo/stories.ts
https://github.com/material-components/material-web/blob/main/labs/segmentedbuttonset/README.md
https://material-web.dev/components/segmented-button/
https://m3.material.io/components/segmented-buttons/overview
*/

@JsModule("@material/web/labs/segmentedbuttonset/outlined-segmented-button-set.js")
private external object SegmentedButtonSetImport

@MaterialWebLabsApi
@Composable
fun MdSegmentedButtonSet(
    multiselect: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    SegmentedButtonSetImport // Load the web component

    TagElement("md-segmented-button-set", {
        multiselect?.let { attr("multiselect", it) }

        attrs?.invoke(this)
    }, content)
}
