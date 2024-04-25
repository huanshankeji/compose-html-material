package com.huanshankeji.compose.web.attributes

import com.varabyte.kobweb.compose.css.disabled
import org.jetbrains.compose.web.attributes.AttrsScope

/**
 * @see AttrsScope.attr
 */
fun AttrsScope<*>.attr(attr: String, isPresent: Boolean = true) =
    attr(attr, isPresent.toString())

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

// https://www.w3schools.com/tags/att_form.asp
fun AttrsScope<*>.form(formId: String?) {
    formId?.let { attr("form", it) }
}

// https://www.w3schools.com/tags/att_name.asp
fun AttrsScope<*>.name(name: String?) {
    name?.let { attr("name", it) }
}

// https://www.w3schools.com/tags/att_required.asp
// https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/required
fun AttrsScope<*>.required(required: Boolean?) {
    required?.let { attr("required", it) }
}
