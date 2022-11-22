package com.huanshankeji.compose.web.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.CenteredInViewport
import com.huanshankeji.compose.web.Styles
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.HTMLDivElement

@Composable
fun CenteredCardInViewport(
    viewportDivStyles: Styles? = null,
    cardAttrs: (AttrsScope<HTMLDivElement>.() -> Unit)? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    CenteredInViewport(viewportDivStyles) {
        MdcCard(cardAttrs, content = content)
    }
