package com.huanshankeji.compose.web.dom.ext

import org.w3c.dom.HTMLElement

/**
 * @see com.huanshankeji.compose.web.attributes.ext.onInput
 */
var HTMLElement.value: String
    get() = asDynamic().value as String
    set(value) {
        asDynamic().value = value
    }
