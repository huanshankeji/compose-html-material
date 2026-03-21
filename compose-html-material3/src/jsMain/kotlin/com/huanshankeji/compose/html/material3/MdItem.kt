package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/item/internal/item.ts
https://github.com/material-components/material-web/blob/main/labs/item/demo/stories.ts
*/

@JsModule("@material/web/labs/item/item.js")
private external object ItemImport

@MaterialWebLabsApi
@Composable
fun MdItem(
    // https://github.com/material-components/material-web/blob/516cbc02bf770b7c3c5c6b546f1e5d81939b9f23/labs/item/internal/item.ts#L14-L21
    multiline: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdItemScope.() -> Unit)? = null
) {
    ItemImport // Load the web component

    TagElement("md-item", {
        attrIfNotNull("multiline", multiline)

        attrs?.invoke(this)
    }) {
        content?.let { MdItemScope(this).it() }
    }
}

class MdItemScope(override val elementScope: ElementScope<HTMLElement>) : IMdItemScope
