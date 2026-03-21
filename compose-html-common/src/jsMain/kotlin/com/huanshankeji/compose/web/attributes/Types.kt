package com.huanshankeji.compose.web.attributes

import org.jetbrains.compose.web.attributes.AttrsScope

@Deprecated(
    "Use the official AttrBuilderContext instead.",
    ReplaceWith("AttrBuilderContext<Element>", "org.jetbrains.compose.web.dom.AttrBuilderContext")
)
typealias Attrs<Element> = AttrsScope<Element>.() -> Unit
