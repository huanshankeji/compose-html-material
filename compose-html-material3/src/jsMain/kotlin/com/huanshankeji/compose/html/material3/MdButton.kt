package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/button.md
https://material-web.dev/components/button/
https://material-web.dev/components/button/stories/
https://m3.material.io/components/buttons/overview
*/

@JsModule("@material/web/button/elevated-button.js")
private external object ElevatedButtonImport

@JsModule("@material/web/button/filled-button.js")
private external object FilledButtonImport

@JsModule("@material/web/button/filled-tonal-button.js")
private external object FilledTonalButtonImport

@JsModule("@material/web/button/outlined-button.js")
private external object OutlinedButtonImport

@JsModule("@material/web/button/text-button.js")
private external object TextButtonImport

private fun commonButtonAttrs(
    disabled: Boolean?,
    href: String?,
    target: String?,
    trailingIcon: Boolean?,
    hasIcon: Boolean?,
    type: String?,
    value: String?,
    name: String?,
    form: String?,
    attrs: AttrBuilderContext<HTMLElement>?
): AttrBuilderContext<HTMLElement> =
    {
        disabled(disabled)
        href(href)
        target(target)
        attrIfNotNull("trailing-icon", trailingIcon)
        attrIfNotNull("has-icon", hasIcon)
        type(type)
        value(value)
        name(name)
        form(form)

        attrs?.invoke(this)
    }

private fun (@Composable MdButtonScope.() -> Unit)?.toElementScopeContentBuilder(): ContentBuilder<HTMLElement>? =
    toElementScopeContentBuilder(::MdButtonScope)

@Composable
private fun CommonButton(
    tagName: String,
    disabled: Boolean?,
    href: String?,
    target: String?,
    trailingIcon: Boolean?,
    hasIcon: Boolean?,
    type: String?,
    value: String?,
    name: String?,
    form: String?, // The form ID
    attrs: AttrBuilderContext<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) =
    //TagElement({ MdElevatedButton().asDynamic() }, { TODO() }) { TODO() }
    TagElement(
        tagName,
        commonButtonAttrs(disabled, href, target, trailingIcon, hasIcon, type, value, name, form, attrs),
        content.toElementScopeContentBuilder()
    )

@Composable
fun MdElevatedButton(
    disabled: Boolean? = null,
    href: String? = null,
    target: String? = null,
    trailingIcon: Boolean? = null,
    hasIcon: Boolean? = null,
    type: String? = null,
    value: String? = null,
    name: String? = null,
    form: String? = null,
    attrs: AttrBuilderContext<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    ElevatedButtonImport // Load the web component

    CommonButton(
        "md-elevated-button",
        disabled, href, target, trailingIcon, hasIcon, type, value, name, form,
        attrs, content
    )
}

@Composable
fun MdFilledButton(
    disabled: Boolean? = null,
    href: String? = null,
    target: String? = null,
    trailingIcon: Boolean? = null,
    hasIcon: Boolean? = null,
    type: String? = null,
    value: String? = null,
    name: String? = null,
    form: String? = null, // The form ID
    attrs: AttrBuilderContext<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    FilledButtonImport // Load the web component

    CommonButton(
        "md-filled-button",
        disabled, href, target, trailingIcon, hasIcon, type, value, name, form,
        attrs, content
    )
}

@Composable
fun MdFilledTonalButton(
    disabled: Boolean? = null,
    href: String? = null,
    target: String? = null,
    trailingIcon: Boolean? = null,
    hasIcon: Boolean? = null,
    type: String? = null,
    value: String? = null,
    name: String? = null,
    form: String? = null, // The form ID
    attrs: AttrBuilderContext<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    FilledTonalButtonImport // Load the web component

    CommonButton(
        "md-filled-tonal-button",
        disabled, href, target, trailingIcon, hasIcon, type, value, name, form,
        attrs, content
    )
}

@Composable
fun MdOutlinedButton(
    disabled: Boolean? = null,
    href: String? = null,
    target: String? = null,
    trailingIcon: Boolean? = null,
    hasIcon: Boolean? = null,
    type: String? = null,
    value: String? = null,
    name: String? = null,
    form: String? = null, // The form ID
    attrs: AttrBuilderContext<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    OutlinedButtonImport // Load the web component

    CommonButton(
        "md-outlined-button",
        disabled, href, target, trailingIcon, hasIcon, type, value, name, form,
        attrs, content
    )
}

@Composable
fun MdTextButton(
    disabled: Boolean? = null,
    href: String? = null,
    target: String? = null,
    trailingIcon: Boolean? = null,
    hasIcon: Boolean? = null,
    type: String? = null,
    value: String? = null,
    name: String? = null,
    form: String? = null, // The form ID
    attrs: AttrBuilderContext<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    TextButtonImport // Load the web component

    CommonButton(
        "md-text-button",
        disabled, href, target, trailingIcon, hasIcon, type, value, name, form,
        attrs, content
    )
}


class MdButtonScope(val elementScope: ElementScope<HTMLElement>) : SlotScope<MdButtonScope.Slot> {
    enum class Slot(override val value: String) : ISlot {
        Icon("icon")
    }

    @Deprecated("Use slot(Slot.Icon) instead.", ReplaceWith("this.slot(MdButtonScope.Slot.Icon)"))
    fun AttrsScope<*>.slotEqIcon() =
        slot(Slot.Icon)
}
