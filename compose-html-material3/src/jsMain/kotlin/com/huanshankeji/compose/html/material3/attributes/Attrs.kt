package com.huanshankeji.compose.html.material3.attributes

import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.attributes.AttrsScope

fun AttrsScope<*>.indeterminate(indeterminate: Boolean?) =
    attrIfNotNull("indeterminate", indeterminate)
