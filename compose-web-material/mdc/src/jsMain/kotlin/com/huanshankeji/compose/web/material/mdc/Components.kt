package com.huanshankeji.compose.web.material.mdc

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.material.defaultSpacing
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement


@Composable
fun MdcCard(
    attrs: (AttrsScope<HTMLDivElement>.() -> Unit)? = null,
    padding: CSSNumeric = defaultSpacing,
    content: ContentBuilder<HTMLDivElement>? = null
) =
    Div({
        classes("mdc-card")
        style {
            padding(padding)
        }
        attrs?.invoke(this)
    }, content)
