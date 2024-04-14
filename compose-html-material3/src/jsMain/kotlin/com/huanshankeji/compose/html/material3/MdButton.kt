package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.disabled
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLFormElement

external fun require(module: String): dynamic

/*
// TODO not working
@JsModule("@material/web/button/elevated-button.js")
external class MdElevatedButton /* : Element */ // TODO

private var toImport = true
*/

// https://github.com/material-components/material-web/blob/main/docs/components/button.md
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
    form: HTMLFormElement? = null,
    ariaLabel: String? = null,
    attrs: (AttrsScope<HTMLElement>.() -> Unit)?,
    content: (@Composable MdButtonScope.() -> Unit)?
) {
    /*
    // TODO not working
    if (toImport) {
        MdElevatedButton()
        toImport = false
    }
    */
    // It seems there is no need to put this in an effect block, because it seems on Compose HTML recomposition happens exactly when there is a need to re-invoke a composable.
    require("@material/web/button/elevated-button.js")

    //TagElement({ MdElevatedButton().asDynamic() }, { TODO() }) { TODO() }
    @Suppress("RemoveExplicitTypeArguments")
    TagElement<HTMLElement>("md-elevated-button", {
        disabled?.let { disabled(it) }
        href?.let { attr("href", it) }
        target?.let { attr("target", it) }
        trailingIcon?.let { attr("trailing-icon", it.toString()) }
        hasIcon?.let { attr("has-icon", it.toString()) }
        type?.let { attr("type", it) }
        value?.let { attr("value", it) }
        name?.let { attr("name", it) }
        form?.let { TODO() }
        // ariaLabel?.let { TODO() } // TODO remove as it's a universal attribute
        attrs?.invoke(this)
    }, content?.let {
        { MdButtonScope(this).it() }
    })
}

class MdButtonScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotIcon() =
        attr("slot", "icon")
}
