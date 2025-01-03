package com.huanshankeji.compose.html.material3

import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/fab.md
https://material-web.dev/components/fab/
https://material-web.dev/components/fab/stories/
 */

fun <TElement : Element> SimplifiedTagElement(
    content: (ElementScope<TElement>.() -> Unit)?
) {
    TODO()
}

class MdFabScope(val elementScope: ElementScope<HTMLElement>)

private fun SimplifiedMdFab(
    content: (MdFabScope.() -> Unit)?
) =
    SimplifiedTagElement(content?.let {
        { MdFabScope(this).it() }
    })
