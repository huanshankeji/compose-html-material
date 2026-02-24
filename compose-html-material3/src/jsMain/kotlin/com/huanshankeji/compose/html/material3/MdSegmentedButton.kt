package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.disabled
import com.huanshankeji.compose.web.attributes.ext.label
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/segmentedbutton/internal/segmented-button.ts
*/

@JsModule("@material/web/labs/segmentedbutton/outlined-segmented-button.js")
private external object OutlinedSegmentedButtonImport

@MaterialWebLabsApi
@Composable
fun MdOutlinedSegmentedButton(
    disabled: Boolean? = null,
    selected: Boolean? = null,
    label: String? = null,
    noCheckmark: Boolean? = null,
    hasIcon: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable MdSegmentedButtonScope.() -> Unit)? = null
) {
    OutlinedSegmentedButtonImport // Load the web component

    TagElement("md-outlined-segmented-button", {
        disabled(disabled)
        attrIfNotNull("selected", selected)
        label(label)
        attrIfNotNull("no-checkmark", noCheckmark)
        attrIfNotNull("has-icon", hasIcon)

        attrs?.invoke(this)
    }, content?.let {
        { MdSegmentedButtonScope(this).it() }
    })
}

class MdSegmentedButtonScope(val elementScope: ElementScope<HTMLElement>) {
    fun AttrsScope<*>.slotEqIcon() =
        slot("icon")
}
