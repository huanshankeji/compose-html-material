package com.huanshankeji.compose.web.attributes

// consider moving to a "web-common" or "html-common" module

fun Boolean.isTrueOrNull(): Boolean? =
    if (this) true else null

fun Boolean.isFalseOrNull(): Boolean? =
    if (this) null else false

fun Boolean.toOnOrOff(): String =
    if (this) "on" else "off"
