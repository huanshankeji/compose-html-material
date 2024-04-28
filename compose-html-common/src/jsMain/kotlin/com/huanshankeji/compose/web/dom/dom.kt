package com.huanshankeji.compose.web.dom

import org.w3c.dom.HTMLElement

/**
 * @see com.huanshankeji.compose.web.attributes.onInput
 */
val HTMLElement.value: String
    get() = asDynamic().value as String
