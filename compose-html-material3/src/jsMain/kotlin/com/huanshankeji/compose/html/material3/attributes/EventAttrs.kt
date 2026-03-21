package com.huanshankeji.compose.html.material3.attributes

import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.events.EventTarget

// menu events (used by both MdMenu and MdSelect)

internal fun <T : SyntheticEvent<out EventTarget>> AttrsScope<*>.commonOnOpening(listener: (T) -> Unit) =
    addEventListener("opening", listener)

internal fun <T : SyntheticEvent<out EventTarget>> AttrsScope<*>.commonOnOpened(listener: (T) -> Unit) =
    addEventListener("opened", listener)

internal fun <T : SyntheticEvent<out EventTarget>> AttrsScope<*>.commonOnClosing(listener: (T) -> Unit) =
    addEventListener("closing", listener)

internal fun <T : SyntheticEvent<out EventTarget>> AttrsScope<*>.commonOnClosed(listener: (T) -> Unit) =
    addEventListener("closed", listener)
