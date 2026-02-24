package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attr
import com.huanshankeji.compose.web.attributes.ext.label
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/fab.md
https://material-web.dev/components/fab/
https://material-web.dev/components/fab/stories/
https://m3.material.io/components/floating-action-button/overview
 */

@JsModule("@material/web/fab/fab.js")
private external object FabImport

@JsModule("@material/web/fab/branded-fab.js")
private external object BrandedFabImport

enum class FabVariant(val value: String) {
    Surface("surface"), Primary("primary"), Secondary("secondary"), Tertiary("tertiary")
}

enum class FabSize(val value: String) {
    Small("small"), Medium("medium"), Large("large")
}

@Composable
private fun CommonMdFab(
    tagName: String,
    variant: FabVariant?,
    size: FabSize?,
    label: String?,
    lowered: Boolean?,
    attrs: Attrs<HTMLElement>?,
    content: (@Composable MdFabScope.() -> Unit)?
) =
    TagElement(tagName, {
        variant?.let { attr("variant", it.value) }
        size?.let { attr("size", it.value) }
        label?.let { label(it) }
        lowered?.let { attr("lowered", it) }

        attrs?.invoke(this)
    }, content?.let {
        { MdFabScope(this).it() }
    })

@Composable
fun MdFab(
    variant: FabVariant? = null,
    size: FabSize? = null,
    label: String? = null,
    lowered: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdFabScope.() -> Unit)? = null
) {
    FabImport // Load the web component

    CommonMdFab("md-fab", variant, size, label, lowered, attrs, content)
}

@Composable
fun MdBrandedFab(
    variant: FabVariant? = null,
    size: FabSize? = null,
    label: String? = null,
    lowered: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdFabScope.() -> Unit)? = null
) {
    BrandedFabImport // Load the web component

    CommonMdFab("md-branded-fab", variant, size, label, lowered, attrs, content)
}


class MdFabScope(val elementScope: ElementScope<HTMLElement>) {
    enum class Slot(val value: String) {
        Icon("icon")
    }

    fun AttrsScope<*>.slot(slot: Slot) =
        slot(slot.value)
}
