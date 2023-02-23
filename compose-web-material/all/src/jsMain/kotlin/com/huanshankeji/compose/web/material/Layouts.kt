package com.huanshankeji.compose.web.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.CenteredInViewport
import com.huanshankeji.compose.web.css.Styles
import com.huanshankeji.compose.web.material.mdc.MdcCard
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.HTMLDivElement

// TODO: consider moving into a separate module
@Composable
fun CenteredCardInViewport(
    viewportDivStyles: Styles? = null,
    cardAttrs: (AttrsScope<HTMLDivElement>.() -> Unit)? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    CenteredInViewport({ viewportDivStyles?.let { style { it() } } }) {
        MdcCard(cardAttrs, content = content)
    }
