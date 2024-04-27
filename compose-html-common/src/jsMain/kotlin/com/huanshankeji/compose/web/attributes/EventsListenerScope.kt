package com.huanshankeji.compose.web.attributes

import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.EventsListenerScope
import org.w3c.dom.events.EventTarget

fun EventsListenerScope.onInput(
    listener: (SyntheticEvent<EventTarget>) -> Unit
) =
    addEventListener(EventsListenerScope.INPUT, listener)
