package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.ext.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/button.md
https://material-web.dev/components/button/
https://material-web.dev/components/button/stories/
*/

/*
// TODO not working
@JsModule("@material/web/button/elevated-button.js")
external class MdElevatedButton /* : Element */ // TODO

private var toImport = true
*/

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
    attrs: Attrs<HTMLElement>?
): Attrs<HTMLElement> =
    {
        disabled(disabled)
        href(href)
        target(target)
        trailingIcon?.let { attr("trailing-icon", it.toString()) }
        hasIcon?.let { attr("has-icon", it.toString()) }
        type(type)
        value(value)
        name(name)
        form(form)

        attrs?.invoke(this)
    }

private fun (@Composable MdButtonScope.() -> Unit)?.toElementScopeContent(): (@Composable ElementScope<HTMLElement>.() -> Unit)? =
    this?.let {
        { MdButtonScope(this).it() }
    }

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
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) =
    //TagElement({ MdElevatedButton().asDynamic() }, { TODO() }) { TODO() }
    TagElement(
        tagName,
        commonButtonAttrs(disabled, href, target, trailingIcon, hasIcon, type, value, name, form, attrs),
        content.toElementScopeContent()
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
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    /*
        // TODO not working
        if (toImport) {
            MdElevatedButton()
            toImport = false
        }
        */
    // `require` can't be wrapped in `CommonButton` taken a `module` parameter because it seems to be processed by Webpack, JS `require` only takes constants.
    // It seems there is no need to put this in an effect block, because it seems on Compose HTML recomposition happens exactly when there is a need to re-invoke a composable.
    require("@material/web/button/elevated-button.js")

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
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    require("@material/web/button/filled-button.js")

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
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    require("@material/web/button/filled-tonal-button.js")

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
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    require("@material/web/button/outlined-button.js")

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
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    require("@material/web/button/text-button.js")

    CommonButton(
        "md-text-button",
        disabled, href, target, trailingIcon, hasIcon, type, value, name, form,
        attrs, content
    )
}


class MdButtonScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqIcon() =
        attr("slot", "icon")
}
