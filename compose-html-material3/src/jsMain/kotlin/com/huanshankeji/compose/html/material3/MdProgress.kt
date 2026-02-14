package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.html.material3.attributes.indeterminate
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/progress.md
https://material-web.dev/components/progress/
https://material-web.dev/components/progress/stories/
 */

@JsModule("@material/web/progress/linear-progress.js")
@JsNonModule
private external object LinearProgressImport

@JsModule("@material/web/progress/circular-progress.js")
@JsNonModule
private external object CircularProgressImport

@Composable
private fun CommonMdProgress(
    tagName: String,
    attrsBefore: Attrs<HTMLElement>?,
    value: Number?,
    max: Number?,
    indeterminate: Boolean?,
    fourColor: Boolean?,
    attrs: Attrs<HTMLElement>?,
    content: @Composable (ElementScope<HTMLElement>.() -> Unit)?
) =
    TagElement(tagName, {
        attrsBefore?.invoke(this)

        attrIfNotNull("value", value)
        attrIfNotNull("max", max)
        indeterminate(indeterminate)
        attrIfNotNull("four-color", fourColor)

        attrs?.invoke(this)
    }, content)

@Composable
fun MdLinearProgress(
    buffer: Number? = null,
    value: Number? = null,
    max: Number? = null,
    indeterminate: Boolean? = null,
    fourColor: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (ElementScope<HTMLElement>.() -> Unit)? = null
) {
    LinearProgressImport // Load the web component

    CommonMdProgress(
        "md-linear-progress",
        { attrIfNotNull("buffer", buffer) },
        value, max, indeterminate, fourColor, attrs, content
    )
}

@Composable
fun MdCircularProgress(
    value: Number? = null,
    max: Number? = null,
    indeterminate: Boolean? = null,
    fourColor: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (ElementScope<HTMLElement>.() -> Unit)? = null
) {
    CircularProgressImport // Load the web component

    CommonMdProgress(
        "md-circular-progress",
        null,
        value, max, indeterminate, fourColor, attrs, content
    )
}
