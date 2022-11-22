package com.huanshankeji.compose.web

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

// follow names in Android Jetpack Compose

@Composable
fun Flexbox(
    styles: Styles? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Div({
        style {
            display(DisplayStyle.Flex)
            styles?.invoke(this)
        }
    }, content)

@Composable
fun Column(
    styles: Styles? = null,
    fitContent: Boolean = true,
    content: ContentBuilder<HTMLDivElement>
) =
    Flexbox({
        flexDirection(FlexDirection.Column)
        if (fitContent) property("width", "fit-content")
        styles?.invoke(this)
    }, content)

@Composable
fun ColumnWithSpaceBetween(
    styles: Styles? = null,
    fitContent: Boolean = true,
    content: ContentBuilder<HTMLDivElement>
) =
    Column({
        justifyContent(JustifyContent.SpaceBetween)
        styles?.invoke(this)
    }, fitContent, content)

@Composable
fun Row(
    styles: Styles? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Flexbox({
        flexDirection(FlexDirection.Row)
        styles?.invoke(this)
    }, content)

@Composable
fun RowWithSpaceBetween(
    styles: Styles? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Row({
        justifyContent(JustifyContent.SpaceBetween)
        styles?.invoke(this)
    }, content)

@Composable
fun ColumnWithGaps(
    styles: Styles? = null,
    gap: CSSNumeric,
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
    gap: CSSNumeric,
    content: ContentBuilder<HTMLDivElement>
) =
    Row({
        gap(gap)
        styles?.invoke(this)
    }, content)

@Composable
fun Centered(
    styles: Styles? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Flexbox({
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
        styles?.invoke(this)
    }, content)

@Composable
fun CenteredInViewport(
    styles: Styles? = null,
    content: ContentBuilder<HTMLDivElement>
) =
    Centered({
        minHeight(100.vh)
        styles?.invoke(this)
    }, content)

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

@Composable
fun Spacer(numPxs: Int) =
    TODO() as Unit
