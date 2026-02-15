package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/labs/navigationbar/internal/navigation-bar.ts
https://github.com/material-components/material-web/blob/main/labs/navigationbar/demo/stories.ts
 */

@JsModule("@material/web/labs/navigationbar/navigation-bar.js")
private external object NavigationBarImport

@MaterialWebLabsApi
@Composable
fun MdNavigationBar(
    activeIndex: Int? = null,
    hideInactiveLabels: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable (ElementScope<HTMLElement>.() -> Unit)?
) {
    NavigationBarImport // Load the web component

    TagElement("md-navigation-bar", {
        attrIfNotNull("active-index", activeIndex)
        attrIfNotNull("hide-inactive-labels", hideInactiveLabels)

        attrs?.invoke(this)
    }, content)
}
