package com.huanshankeji.compose.html.material3.attributes

import com.huanshankeji.compose.web.attributes.attr
import org.jetbrains.compose.web.attributes.AttrsScope

fun AttrsScope<*>.indeterminate(indeterminate: Boolean?) {
    indeterminate?.let { attr("indeterminate", it) }
}
