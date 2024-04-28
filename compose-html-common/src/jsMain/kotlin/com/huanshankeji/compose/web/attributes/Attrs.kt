package com.huanshankeji.compose.web.attributes

import org.jetbrains.compose.web.attributes.AttrsScope

/**
 * @see AttrsScope.attr
 */
fun AttrsScope<*>.attr(attr: String, value: Boolean = true) =
    attr(attr, value.toString())

/**
 * [Int] attributes are used in Compose HTML. See [org.jetbrains.compose.web.attributes.maxLength] for example.
 */
fun AttrsScope<*>.attr(attr: String, value: Int) =
    attr(attr, value.toString())


fun AttrsScope<*>.attrIfNotNull(attr: String, value: String?) {
    value?.let { attr(attr, it) }
}

fun AttrsScope<*>.attrIfNotNull(attr: String, isPresent: Boolean?) {
    isPresent?.let { attr(attr, it) }
}

fun AttrsScope<*>.attrIfNotNull(attr: String, value: Int?) {
    value?.let { attr(attr, it) }
}


// https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/slot
fun AttrsScope<*>.slot(value: String) =
    attr("slot", value)
