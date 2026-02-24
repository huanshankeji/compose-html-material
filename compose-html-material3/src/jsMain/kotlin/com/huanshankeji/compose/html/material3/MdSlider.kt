package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attrIfNotNull
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
        attrIfNotNull("min", min)
        attrIfNotNull("max", max)
        attrIfNotNull("value", value)
        attrIfNotNull("value-start", valueStart)
        attrIfNotNull("value-end", valueEnd)
        attrIfNotNull("value-label", valueLabel)
        attrIfNotNull("value-label-start", valueLabelStart)
        attrIfNotNull("value-label-end", valueLabelEnd)
        attrIfNotNull("aria-label-start", ariaLabelStart)
        attrIfNotNull("aria-valuetext-start", ariaValueTextStart)
        attrIfNotNull("aria-label-end", ariaLabelEnd)
        attrIfNotNull("aria-valuetext-end", ariaValueTextEnd)
        attrIfNotNull("step", step)
        attrIfNotNull("ticks", ticks)
        attrIfNotNull("labeled", labeled)
        attrIfNotNull("range", range)
        // disabled, name, nameStart, nameEnd have no corresponding HTML attribute (property only)

        attrs?.invoke(this)
    }, content)
}
