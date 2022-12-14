package com.huanshankeji.compose.web

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

typealias ElementComposable<TElement> = @Composable (
    attrs: AttrBuilderContext<TElement>?,
    content: ContentBuilder<TElement>?
) -> Unit

typealias DivElementComposable = ElementComposable<HTMLDivElement>

// `::Div` cannot be used directly because "Function References of @Composable functions are not currently supported"
val DivComposable: ElementComposable<HTMLDivElement> = { attrs, content -> Div(attrs, content) }

typealias HTMLElementContent = (@Composable ElementScope<HTMLElement>.() -> Unit)?
