package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/card/internal/card.ts
https://github.com/material-components/material-web/blob/main/labs/card/demo/stories.ts
 */

@JsModule("@material/web/labs/card/elevated-card.js")
@JsNonModule
private external object ElevatedCardImport

@JsModule("@material/web/labs/card/filled-card.js")
@JsNonModule
private external object FilledCardImport

@JsModule("@material/web/labs/card/outlined-card.js")
@JsNonModule
private external object OutlinedCardImport

@MaterialWebLabsApi
@Composable
fun MdElevatedCard(
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (ElementScope<HTMLElement>.() -> Unit)?
) {
    ElevatedCardImport // Load the web component

    TagElement("md-elevated-card", attrs, content)
}

@MaterialWebLabsApi
@Composable
fun MdFilledCard(
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (ElementScope<HTMLElement>.() -> Unit)?
) {
    FilledCardImport // Load the web component

    TagElement("md-filled-card", attrs, content)
}

@MaterialWebLabsApi
@Composable
fun MdOutlinedCard(
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (ElementScope<HTMLElement>.() -> Unit)?
) {
    OutlinedCardImport // Load the web component

    TagElement("md-outlined-card", attrs, content)
}
