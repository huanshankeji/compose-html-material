@file:Suppress("NOTHING_TO_INLINE")

package com.huanshankeji.compose.web.css

import org.jetbrains.compose.web.css.StylePropertyEnum
import org.jetbrains.compose.web.css.StyleScope

fun StyleScope.visibility(visibility: Visibility) =
    property("visibility", visibility)

interface Visibility : StylePropertyEnum {
    companion object {
        inline val Visible get() = Visibility("visible")
        inline val Hidden get() = Visibility("hidden")
        inline val Collapse get() = Visibility("collapse")
    }
}

inline fun Visibility(value: String) = value.unsafeCast<Visibility>()
