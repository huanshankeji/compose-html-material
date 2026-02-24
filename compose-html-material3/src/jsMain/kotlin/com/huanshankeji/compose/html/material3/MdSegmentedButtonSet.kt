package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/segmentedbuttonset/internal/segmented-button-set.ts
https://github.com/material-components/material-web/blob/main/labs/segmentedbuttonset/demo/stories.ts
*/

@JsModule("@material/web/labs/segmentedbuttonset/outlined-segmented-button-set.js")
private external object OutlinedSegmentedButtonSetImport

@MaterialWebLabsApi
@Composable
fun MdOutlinedSegmentedButtonSet(
    multiselect: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    OutlinedSegmentedButtonSetImport // Load the web component

    TagElement("md-outlined-segmented-button-set", {
        attrIfNotNull("multiselect", multiselect)

        attrs?.invoke(this)
    }, content)
}
