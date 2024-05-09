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
 */

@Composable
private fun CommonMdFab(
    tagName: String,
    variant: String?,
    size: String?,
    label: String?,
    lowered: Boolean?,
    attrs: Attrs<HTMLElement>?,
    content: @Composable (MdFabScope.() -> Unit)?
) =
    TagElement(tagName, {
        variant?.let { attr("variant", it) }
        size?.let { attr("size", it) }
        label?.let { label(it) }
        lowered?.let { attr("lowered", it) }

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
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (MdFabScope.() -> Unit)?
) {
    require("@material/web/fab/fab.js")

    CommonMdFab("md-fab", variant, size, label, lowered, attrs, content)
}

@Composable
fun MdBrandedFab(
    variant: String? = null,
    size: String? = null,
    label: String? = null,
    lowered: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (MdFabScope.() -> Unit)?
) {
    require("@material/web/fab/branded-fab.js")

    CommonMdFab("md-branded-fab", variant, size, label, lowered, attrs, content)
}


class MdFabScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqIcon() =
        slot("icon")
}
