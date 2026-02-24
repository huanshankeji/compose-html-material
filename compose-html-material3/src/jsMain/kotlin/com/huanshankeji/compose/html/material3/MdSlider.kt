package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/slider.md
https://material-web.dev/components/slider/
https://material-web.dev/components/slider/stories/
https://m3.material.io/components/sliders/overview
*/

@JsModule("@material/web/slider/slider.js")
private external object SliderImport

@Composable
fun MdSlider(
    min: Number? = null,
    max: Number? = null,
    value: Number? = null,
    valueStart: Number? = null,
    valueEnd: Number? = null,
    valueLabel: String? = null,
    valueLabelStart: String? = null,
    valueLabelEnd: String? = null,
    ariaLabelStart: String? = null,
    ariaValueTextStart: String? = null,
    ariaLabelEnd: String? = null,
    ariaValueTextEnd: String? = null,
    step: Number? = null,
    ticks: Boolean? = null,
    labeled: Boolean? = null,
    range: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    SliderImport // Load the web component

    TagElement("md-slider", {
        min?.let { attr("min", it.toString()) }
        max?.let { attr("max", it.toString()) }
        value?.let { attr("value", it.toString()) }
        valueStart?.let { attr("value-start", it.toString()) }
        valueEnd?.let { attr("value-end", it.toString()) }
        valueLabel?.let { attr("value-label", it) }
        valueLabelStart?.let { attr("value-label-start", it) }
        valueLabelEnd?.let { attr("value-label-end", it) }
        ariaLabelStart?.let { attr("aria-label-start", it) }
        ariaValueTextStart?.let { attr("aria-valuetext-start", it) }
        ariaLabelEnd?.let { attr("aria-label-end", it) }
        ariaValueTextEnd?.let { attr("aria-valuetext-end", it) }
        step?.let { attr("step", it.toString()) }
        ticks?.let { attr("ticks", it) }
        labeled?.let { attr("labeled", it) }
        range?.let { attr("range", it) }
        // disabled, name, nameStart, nameEnd have no corresponding HTML attribute (property only)

        attrs?.invoke(this)
    }, content)
}
