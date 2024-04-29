package com.huanshankeji.compose.web.attributes.ext

import com.huanshankeji.compose.web.attributes.AutoCapitalize
import com.huanshankeji.compose.web.attributes.EnterKeyHint
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.autoCapitalize
import com.huanshankeji.compose.web.attributes.enterKeyHint
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.AutoComplete
import org.jetbrains.compose.web.attributes.InputType

/*
Attributes in the `ext` package are one of 2 kinds:
1. Those for `HTMLElement`s which don't implement the interfaces (such as `HTMLInputElement`) of the elements they behave like,
such as the `HTMLElement`s of those components in Material Web.
These attributes should not be universally available on most elements.
1. Those taking nullable values.

Also consider moving to a `compose-html-material-common` module and depend on them with `implementation`.
Consider reordering them.
 */


// https://www.w3schools.com/accessibility/accessibility_labels.php
// https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/Attributes/aria-label
fun AttrsScope<*>.ariaLabel(value: String) =
    attr("aria-label", value)


// https://www.w3schools.com/tags/att_disabled.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/disabled
fun AttrsScope<*>.disabled(disabled: Boolean?) {
    disabled?.let { disabled(it) }
}

// https://www.w3schools.com/tags/att_href.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a#href
fun AttrsScope<*>.href(value: String?) =
    attrIfNotNull("href", value)

// https://www.w3schools.com/tags/att_target.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a#target
fun AttrsScope<*>.target(value: String?) =
    attrIfNotNull("target", value)


// https://www.w3schools.com/tags/att_input_type.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#type
fun AttrsScope<*>.type(value: String?) =
    attrIfNotNull("type", value)

// https://www.w3schools.com/tags/att_value.asp
fun AttrsScope<*>.value(value: String?) =
    attrIfNotNull("value", value)


// https://www.w3schools.com/tags/att_name.asp
fun AttrsScope<*>.name(value: String?) =
    attrIfNotNull("name", value)


// https://www.w3schools.com/tags/att_form.asp
fun AttrsScope<*>.form(value: String?) =
    attrIfNotNull("form", value)

// https://www.w3schools.com/tags/att_required.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/required
fun AttrsScope<*>.required(value: Boolean?) =
    attrIfNotNull("required", value)

// https://www.geeksforgeeks.org/html-label-attribute/
fun AttrsScope<*>.label(value: String?) =
    attrIfNotNull("label", value)

// copied and adapted from `Attrs.kt` in `org.jetbrains.compose.web.attributes`

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#max
fun AttrsScope<*>.max(value: String?) =
    attrIfNotNull("max", value)

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#maxlength
fun AttrsScope<*>.maxLength(value: Int?) =
    attrIfNotNull("maxlength", value)

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#min
fun AttrsScope<*>.min(value: String?) =
    attrIfNotNull("min", value)

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#minlength
fun AttrsScope<*>.minLength(value: Int?) =
    attrIfNotNull("minlength", value)

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#pattern
fun AttrsScope<*>.pattern(value: String?) =
    attrIfNotNull("pattern", value)

// https://www.w3schools.com/tags/att_input_placeholder.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/placeholder
fun AttrsScope<*>.placeholder(value: String?) =
    attrIfNotNull("placeholder", value)

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#readonly
fun AttrsScope<*>.readOnly(value: Boolean?) =
    attrIfNotNull("readonly", value)


// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/email#multiple
fun AttrsScope<*>.multiple(value: Boolean?) =
    attrIfNotNull("multiple", value)

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#step
fun AttrsScope<*>.step(value: String?) =
    attrIfNotNull("step", value)

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#input_types
fun AttrsScope<*>.type(value: InputType<*>?) {
    value?.let { attr("type", it.typeStr) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete
fun AttrsScope<*>.autoComplete(value: AutoComplete?) {
    value?.let { attr("autocomplete", it.unsafeCast<String>()) }
}


// This is actually a global attribute
// https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize
fun AttrsScope<*>.autoCapitalize(value: String?) =
    value?.let { this@autoCapitalize.autoCapitalize(value) }

fun AttrsScope<*>.autoCapitalizeRequiringValid(value: String) {
    require(value in AutoCapitalize.valueSet)
    autoCapitalize(value)
}


fun AttrsScope<*>.enterKeyHintIfValid(value: String) {
    if (value in EnterKeyHint.valueSet) enterKeyHint(value)
}
