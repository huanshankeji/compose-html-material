package com.huanshankeji.compose.web.css

import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.Element

typealias Styles = StyleScope.() -> Unit

fun <TElement : Element> Styles?.wrapInAttrs(): AttrBuilderContext<TElement>? =
    this?.let { { style { it() } } }
