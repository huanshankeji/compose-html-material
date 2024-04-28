package com.huanshankeji.compose.web.attributes.ext

import com.huanshankeji.compose.web.attributes.attr
import com.varabyte.kobweb.compose.css.disabled
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.AutoComplete
import org.jetbrains.compose.web.attributes.InputType

/*
Attributes in this package are for `HTMLElement`s which don't implement the interfaces (such as `HTMLInputElement`) of the elements they behave like,
such as the `HTMLElement`s of those components in Material Web.
These attributes should not be universally available on most elements.
Also consider moving to a `compose-html-material-common` module and depend on them with `implementation`.
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
fun AttrsScope<*>.href(href: String?) {
    href?.let { attr("href", it) }
}

// https://www.w3schools.com/tags/att_target.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a#target
fun AttrsScope<*>.target(target: String?) {
    target?.let { attr("target", it) }
}

// https://www.w3schools.com/tags/att_input_type.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#type
fun AttrsScope<*>.type(type: String?) {
    type?.let { attr("type", it) }
}

// https://www.w3schools.com/tags/att_value.asp
fun AttrsScope<*>.value(value: String?) {
    value?.let { attr("value", it) }
}

// https://www.w3schools.com/tags/att_name.asp
fun AttrsScope<*>.name(name: String?) {
    name?.let { attr("name", it) }
}

// https://www.w3schools.com/tags/att_form.asp
fun AttrsScope<*>.form(formId: String?) {
    formId?.let { attr("form", it) }
}

// https://www.w3schools.com/tags/att_required.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/required
fun AttrsScope<*>.required(required: Boolean?) {
    required?.let { attr("required", it) }
}
// https://www.geeksforgeeks.org/html-label-attribute/
fun AttrsScope<*>.label(label: String?) {
    label?.let { attr("label", it) }
}

// copied and adapted from `Attrs.kt` in `org.jetbrains.compose.web.attributes`

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#max
fun AttrsScope<*>.max(value: String?) {
    value?.let { attr("max", it) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#maxlength
fun AttrsScope<*>.maxLength(value: Int?) {
    value?.let { attr("maxlength", it) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#min
fun AttrsScope<*>.min(value: String?) {
    value?.let { attr("min", it) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#minlength
fun AttrsScope<*>.minLength(value: Int?) {
    value?.let { attr("minlength", it) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#pattern
fun AttrsScope<*>.pattern(value: String?) {
    value?.let { attr("pattern", it) }
}

// https://www.w3schools.com/tags/att_input_placeholder.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/placeholder
fun AttrsScope<*>.placeholder(value: String?) {
    value?.let { attr("placeholder", it) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#readonly
fun AttrsScope<*>.readOnly(value: Boolean?) {
    value?.let { attr("readonly", it) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/email#multiple
fun AttrsScope<*>.multiple(value: Boolean?) {
    value?.let { attr("multiple", it) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#step
fun AttrsScope<*>.step(value: String?) {
    value?.let { attr("step", it) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#input_types
fun AttrsScope<*>.type(value: InputType<*>?) {
    value?.let { attr("type", it.typeStr) }
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete
fun AttrsScope<*>.autoComplete(value: AutoComplete?) {
    value?.let { attr("autocomplete", value.unsafeCast<String>()) }
}
