package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.ext.*
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/slider.md
https://material-web.dev/components/slider/
https://material-web.dev/components/slider/stories/
*/

@JsModule("@material/web/slider/slider.js")
private external object SliderImport

@Composable
fun MdSlider(
    disabled: Boolean? = null,
    min: Number? = null,
    max: Number? = null,
    value: Number? = null,
    valueStart: Number? = null,
    valueEnd: Number? = null,
    step: Number? = null,
    ticks: Boolean? = null,
    labeled: Boolean? = null,
    range: Boolean? = null,
    name: String? = null,
    nameStart: String? = null,
    nameEnd: String? = null,
    form: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    SliderImport // Load the web component

    TagElement("md-slider", {
        disabled(disabled)
        min?.let { attr("min", it.toString()) }
        max?.let { attr("max", it.toString()) }
        value?.let { attr("value", it.toString()) }
        valueStart?.let { attr("value-start", it.toString()) }
        valueEnd?.let { attr("value-end", it.toString()) }
        step?.let { attr("step", it.toString()) }
        ticks?.let { attr("ticks", it) }
        labeled?.let { attr("labeled", it) }
        range?.let { attr("range", it) }
        name(name)
        nameStart?.let { attr("name-start", it) }
        nameEnd?.let { attr("name-end", it) }
        form(form)

        attrs?.invoke(this)
    }, content)
}
