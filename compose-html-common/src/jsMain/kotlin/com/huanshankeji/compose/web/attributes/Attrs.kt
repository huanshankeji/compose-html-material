package com.huanshankeji.compose.web.attributes

import org.jetbrains.compose.web.attributes.AttrsScope

/**
 * Adds an attribute that is made present by its key aka [attr].
 * @see AttrsScope.attr
 */
fun AttrsScope<*>.attr(attr: String, value: Boolean = true) =
    attr(attr, value.toString())

/**
 * [Int] attributes are used in Compose HTML. See [org.jetbrains.compose.web.attributes.maxLength] for example.
 */
fun AttrsScope<*>.attr(attr: String, value: Int) =
    attr(attr, value.toString())

/**
 * Adds an attribute that has an explicit [Boolean] value unlike [attr].
 */
fun AttrsScope<*>.booleanAttr(attr: String, value: Boolean) =
    attr(attr, value.toString())


fun AttrsScope<*>.attrIfNotNull(attr: String, value: String?) {
    value?.let { attr(attr, it) }
}

fun AttrsScope<*>.attrIfNotNull(attr: String, value: Boolean?) {
    value?.let { attr(attr, it) }
}

fun AttrsScope<*>.attrIfNotNull(attr: String, value: Int?) {
    value?.let { attr(attr, it) }
}


// https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/slot
fun AttrsScope<*>.slot(value: String) =
    attr("slot", value)


enum class AutoCapitalize(val strValue: String, val alternativeStrValue: String? = null) {
    None("none", "off"), Sentences("sentences", "on"), Words("words"), Characters("characters");

    companion object {
        val valueSet = entries.asSequence().map { it.strValue }.toSet()
    }
}

// This is actually a global attribute
// https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize
fun AttrsScope<*>.autoCapitalize(value: String) =
    attr("autocapitalize", value)

fun AttrsScope<*>.autoCapitalize(value: AutoCapitalize) =
    autoCapitalize(value.strValue)


// Safari only
// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/Input#attr-autocorrect
fun AttrsScope<*>.autocorrect(value: String) =
    attr("autocorrect", value)

fun AttrsScope<*>.autocorrect(onOrOff: Boolean) =
    attr("autocorrect", onOrOff.toOnOrOff())


enum class EnterKeyHint(val strValue: String) {
    Enter("enter"), Done("done"), Go("go"), Next("next"), Previous("previous"), Search("search"), Send("send");

    companion object {
        val valueSet = entries.map { it.strValue }.toSet()
    }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/enterkeyhint
fun AttrsScope<*>.enterKeyHint(value: String) =
    attr("enterkeyhint", value)

fun AttrsScope<*>.enterKeyHint(value: EnterKeyHint) =
    enterKeyHint(value.strValue)
