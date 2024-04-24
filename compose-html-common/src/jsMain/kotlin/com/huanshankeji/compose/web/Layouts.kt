package com.huanshankeji.compose.web

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrs
import com.huanshankeji.compose.web.attributes.plus
import com.huanshankeji.compose.web.css.FIT_CONTENT
import com.huanshankeji.compose.web.css.Styles
import com.huanshankeji.compose.web.css.width
import com.huanshankeji.compose.web.css.wrapInAttrs
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

// try to follow names in Android Jetpack Compose

// TODO: remove these deprecated functions

const val WITH_STYLES_DEPRECATED_MESSAGE = "The functions with `withStyles` suffixes are deprecated."

@Composable
fun Flexbox(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Div(attrs<HTMLDivElement> {
        style {
            display(DisplayStyle.Flex)
        }
    } + attrs, content)

@PreferringKobwebComposeLayoutApi
@Deprecated(WITH_STYLES_DEPRECATED_MESSAGE)
@Composable
fun FlexboxS(styles: Styles? = null, content: ContentBuilder<HTMLDivElement>) =
    Flexbox(styles.wrapInAttrs(), content)

@PreferringKobwebComposeLayoutApi
@Composable
fun Column(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    fitContent: Boolean = true,
    content: ContentBuilder<HTMLDivElement>
) =
    Flexbox(attrs<HTMLDivElement> {
        style {
            flexDirection(FlexDirection.Column)
            if (fitContent) width(FIT_CONTENT)
        }
    } + attrs, content)

@PreferringKobwebComposeLayoutApi
@Deprecated(WITH_STYLES_DEPRECATED_MESSAGE)
@Composable
fun ColumnS(styles: Styles? = null, fitContent: Boolean = true, content: ContentBuilder<HTMLDivElement>) =
    Column(styles.wrapInAttrs(), fitContent, content)

@PreferringKobwebComposeLayoutApi
@Composable
fun ColumnWithSpaceBetween(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    fitContent: Boolean = true,
    content: ContentBuilder<HTMLDivElement>
) =
    Column(attrs<HTMLDivElement> {
        style {
            justifyContent(JustifyContent.SpaceBetween)
        }
    } + attrs, fitContent, content)


@PreferringKobwebComposeLayoutApi
@Composable
fun Row(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Flexbox(attrs<HTMLDivElement> {
        style {
            flexDirection(FlexDirection.Row)
        }
    } + attrs, content)

@PreferringKobwebComposeLayoutApi
@Deprecated(WITH_STYLES_DEPRECATED_MESSAGE)
@Composable
fun RowS(
    styles: Styles? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Row(styles.wrapInAttrs(), content)

@PreferringKobwebComposeLayoutApi
@Composable
fun RowWithSpaceBetween(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Row(attrs<HTMLDivElement> {
        style {
            justifyContent(JustifyContent.SpaceBetween)
        }
    } + attrs, content)

@PreferringKobwebComposeLayoutApi
@Composable
fun ColumnWithGaps(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    gap: CSSNumeric,
    fitContent: Boolean = true,
    content: ContentBuilder<HTMLDivElement>
) =
    Column(attrs<HTMLDivElement> {
        style {
            gap(gap)
        }
    } + attrs, fitContent, content)

@PreferringKobwebComposeLayoutApi
@Composable
fun RowWithGaps(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    gap: CSSNumeric,
    content: ContentBuilder<HTMLDivElement>
) =
    Row(attrs<HTMLDivElement> {
        style {
            gap(gap)
        }
    } + attrs, content)

@Composable
fun Centered(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Flexbox(attrs<HTMLDivElement> {
        style {
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
        }
    } + attrs, content)

@Composable
fun CenteredInViewport(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Centered(attrs<HTMLDivElement> {
        style {
            minHeight(100.vh)
        }
    } + attrs, content)

@Composable
fun FrGrid(
    numColumns: Int,
    gap: CSSNumeric,
    content: HTMLElementContent
) =
    Div({
        style {
            display(DisplayStyle.Grid)
            gridTemplateColumns("repeat($numColumns, 1fr)")
            gap(gap)
        }
    }, content)

@PreferringKobwebComposeLayoutApi
@Deprecated("This API is not implemented yet.")
@Composable
fun Spacer(numPxs: Int) =
    TODO() as Unit
