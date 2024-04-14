package com.huanshankeji.compose.web.attributes

import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLElement

fun AttrsScope<HTMLElement>.attr(attr: String, isPresent: Boolean = true) =
    attr(attr, isPresent.toString())
