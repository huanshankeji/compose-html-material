package com.huanshankeji.compose.web.attributes

import com.varabyte.kobweb.compose.css.disabled
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.AutoComplete
import org.jetbrains.compose.web.attributes.InputType

/**
 * @see AttrsScope.attr
 */
fun AttrsScope<*>.attr(attr: String, isPresent: Boolean = true) =
    attr(attr, isPresent.toString())

/**
 * [Int] attributes are used in Compose HTML. See [org.jetbrains.compose.web.attributes.maxLength] for example.
 */
fun AttrsScope<*>.attr(attr: String, number: Int) =
    attr(attr, number.toString())

// https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/slot
fun AttrsScope<*>.slot(value: String) =
    attr("slot", value)
