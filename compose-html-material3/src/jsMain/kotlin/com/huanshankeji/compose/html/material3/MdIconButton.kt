package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.ext.*
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement


/*
https://github.com/material-components/material-web/blob/main/docs/components/icon-button.md
https://material-web.dev/components/icon-button/
https://material-web.dev/components/icon-button/stories/
https://m3.material.io/components/icon-buttons/overview
 */

@JsModule("@material/web/iconbutton/icon-button.js")
private external object IconButtonImport

@JsModule("@material/web/iconbutton/filled-icon-button.js")
private external object FilledIconButtonImport

@JsModule("@material/web/iconbutton/filled-tonal-icon-button.js")
private external object FilledTonalIconButtonImport

@JsModule("@material/web/iconbutton/outlined-icon-button.js")
private external object OutlinedIconButtonImport


@Composable
private fun CommonMdIconButton(
    tagName: String,
    disabled: Boolean?,
    flipIconInRtl: Boolean?,
    href: String?,
    target: String?,
    ariaLabelSelected: String?,
    toggle: Boolean?,
    selected: Boolean?,
    type: String?,
    value: String?,
    attrs: Attrs<HTMLElement>?,
    content: @Composable MdIconButtonScope.() -> Unit
) =
    @Suppress("RemoveExplicitTypeArguments")
    TagElement<HTMLElement>(
        tagName,
        {
            disabled(disabled)
            flipIconInRtl?.let { attr("flip-icon-in-rtl", it) }
            href(href)
            target(target)
            ariaLabelSelected?.let { attr("aria-label-selected", it) }
            toggle?.let { attr("toggle", it) }
            selected(selected)
            type(type)
            value(value)

            attrs?.invoke(this)
        }
    ) {
        MdIconButtonScope(this).content()
    }


@Composable
fun MdIconButton(
    disabled: Boolean? = null,
    flipIconInRtl: Boolean? = null,
    href: String? = null,
    target: String? = null,
    ariaLabelSelected: String? = null,
    toggle: Boolean? = null,
    selected: Boolean? = null,
    type: String? = null,
    value: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable MdIconButtonScope.() -> Unit
) {
    IconButtonImport // Load the web component

    CommonMdIconButton(
        "md-icon-button",
        disabled,
        flipIconInRtl,
        href,
        target,
        ariaLabelSelected,
        toggle,
        selected,
        type,
        value,
        attrs,
        content
    )
}

@Composable
fun MdFilledIconButton(
    disabled: Boolean? = null,
    flipIconInRtl: Boolean? = null,
    href: String? = null,
    target: String? = null,
    ariaLabelSelected: String? = null,
    toggle: Boolean? = null,
    selected: Boolean? = null,
    type: String? = null,
    value: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable MdIconButtonScope.() -> Unit
) {
    FilledIconButtonImport // Load the web component

    CommonMdIconButton(
        "md-filled-icon-button",
        disabled,
        flipIconInRtl,
        href,
        target,
        ariaLabelSelected,
        toggle,
        selected,
        type,
        value,
        attrs,
        content
    )
}

@Composable
fun MdFilledTonalIconButton(
    disabled: Boolean? = null,
    flipIconInRtl: Boolean? = null,
    href: String? = null,
    target: String? = null,
    ariaLabelSelected: String? = null,
    toggle: Boolean? = null,
    selected: Boolean? = null,
    type: String? = null,
    value: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable MdIconButtonScope.() -> Unit
) {
    FilledTonalIconButtonImport // Load the web component

    CommonMdIconButton(
        "md-filled-tonal-icon-button",
        disabled,
        flipIconInRtl,
        href,
        target,
        ariaLabelSelected,
        toggle,
        selected,
        type,
        value,
        attrs,
        content
    )
}

@Composable
fun MdOutlinedIconButton(
    disabled: Boolean? = null,
    flipIconInRtl: Boolean? = null,
    href: String? = null,
    target: String? = null,
    ariaLabelSelected: String? = null,
    toggle: Boolean? = null,
    selected: Boolean? = null,
    type: String? = null,
    value: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable MdIconButtonScope.() -> Unit
) {
    OutlinedIconButtonImport // Load the web component

    CommonMdIconButton(
        "md-outlined-icon-button",
        disabled,
        flipIconInRtl,
        href,
        target,
        ariaLabelSelected,
        toggle,
        selected,
        type,
        value,
        attrs,
        content
    )
}


class MdIconButtonScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqSelected() =
        slot("selected")
}
