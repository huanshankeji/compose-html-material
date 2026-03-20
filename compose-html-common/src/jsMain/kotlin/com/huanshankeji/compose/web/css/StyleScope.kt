package com.huanshankeji.compose.web.css

import org.jetbrains.compose.web.css.StyleScope

fun StyleScope.width(value: String) =
    property("width", value)

fun StyleScope.height(value: String) =
    property("height", value)

@Deprecated("Use the style functions in `com.varabyte.kobweb.compose.css` with `FitContent` instead.")
const val FIT_CONTENT = "fit-content"
