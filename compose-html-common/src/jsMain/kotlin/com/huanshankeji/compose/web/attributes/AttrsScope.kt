package com.huanshankeji.compose.web.attributes

import com.varabyte.kobweb.compose.css.disabled
import org.jetbrains.compose.web.attributes.AttrsScope

fun AttrsScope<*>.attr(attr: String, isPresent: Boolean = true) =
    attr(attr, isPresent.toString())

fun AttrsScope<*>.ariaLabel(value: String) =
    attr("aria-label", value)

fun AttrsScope<*>.disabled(disabled: Boolean?) {
    disabled?.let { disabled(it) }
}

fun AttrsScope<*>.href(href: String?) {
    href?.let { attr("href", it) }
}

fun AttrsScope<*>.target(target: String?) {
    target?.let { attr("target", it) }
}

fun AttrsScope<*>.type(type: String?) {
    type?.let { attr("type", it) }
}

fun AttrsScope<*>.value(value: String?) {
    value?.let { attr("value", it) }
}

fun AttrsScope<*>.form(formId: String?) {
    formId?.let { attr("form", it) }
}

fun AttrsScope<*>.name(name: String?) {
    name?.let { attr("name", it) }
}
