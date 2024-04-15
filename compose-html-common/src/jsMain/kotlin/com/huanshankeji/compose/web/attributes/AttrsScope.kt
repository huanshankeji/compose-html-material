package com.huanshankeji.compose.web.attributes

import org.jetbrains.compose.web.attributes.AttrsScope

fun AttrsScope<*>.attr(attr: String, isPresent: Boolean = true) =
    attr(attr, isPresent.toString())

fun AttrsScope<*>.ariaLabel(value: String) =
    attr("aria-label", value)
