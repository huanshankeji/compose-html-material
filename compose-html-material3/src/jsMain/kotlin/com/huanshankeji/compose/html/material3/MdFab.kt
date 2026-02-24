package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.label
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
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

@Composable
private fun CommonMdFab(
    tagName: String,
    variant: String?,
    size: String?,
    label: String?,
    lowered: Boolean?,
    attrs: AttrBuilderContext<HTMLElement>?,
    content: @Composable (MdFabScope.() -> Unit)?
) =
    TagElement(tagName, {
        attrIfNotNull("variant", variant)
        attrIfNotNull("size", size)
        label?.let { label(it) }
        attrIfNotNull("lowered", lowered)

        attrs?.invoke(this)
    }, content?.let {
        { MdFabScope(this).it() }
    })

@Composable
fun MdFab(
    variant: String? = null,
    size: String? = null,
    label: String? = null,
    lowered: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable (MdFabScope.() -> Unit)?
) {
    FabImport // Load the web component

    CommonMdFab("md-fab", variant, size, label, lowered, attrs, content)
}

@Composable
fun MdBrandedFab(
    variant: String? = null,
    size: String? = null,
    label: String? = null,
    lowered: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable (MdFabScope.() -> Unit)?
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

    @Deprecated("Use slot(Slot.Icon) instead.", ReplaceWith("this.slot(MdFabScope.Slot.Icon)"))
    fun AttrsScope<*>.slotEqIcon() =
        slot(Slot.Icon)
}
