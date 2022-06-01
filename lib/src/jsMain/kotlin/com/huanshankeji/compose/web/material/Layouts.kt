package com.huanshankeji.compose.web.material

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.CenteredInViewport
import com.huanshankeji.compose.web.Column
import com.huanshankeji.compose.web.Row
import com.huanshankeji.compose.web.Styles
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.HTMLDivElement

@Composable
fun ColumnWithGaps(
    styles: Styles? = null,
    gap: CSSNumeric = defaultSpacing,
    fitContent: Boolean = true,
    content: ContentBuilder<HTMLDivElement>
) =
    Column({
        gap(gap)
        styles?.invoke(this)
    }, fitContent, content)

@Composable
fun RowWithGaps(
    styles: Styles? = null,
    gap: CSSNumeric = defaultSpacing,
    content: ContentBuilder<HTMLDivElement>
) =
    Row({
        gap(gap)
        styles?.invoke(this)
    }, content)

@Composable
fun CenteredCardInViewport(
    viewportDivStyles: Styles? = null,
    cardAttrs: (AttrsScope<HTMLDivElement>.() -> Unit)? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    CenteredInViewport(viewportDivStyles) {
        MdcCard(cardAttrs, content = content)
    }
