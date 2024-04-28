package com.huanshankeji.compose.web.attributes.ext

import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.EventsListenerScope
import org.w3c.dom.HTMLElement

/**
 * @see com.huanshankeji.compose.web.dom.value
 */
//fun <Element : EventTarget> EventsListenerScope.onInput(
fun <TElement : HTMLElement> AttrsScope<TElement>.onInput(
    listener: (SyntheticEvent<TElement>) -> Unit
) =
    addEventListener(EventsListenerScope.INPUT, listener)
