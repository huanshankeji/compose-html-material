package com.huanshankeji.compose.html.material3

import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLElement

/**
 * A common scope interface for components extending or wrapping `MdItem`.
 * See https://github.com/material-components/material-web/blob/main/labs/item/item.ts.
 * More specifically,
 * https://github.com/material-components/material-web/blob/2f150d28414c7b2757bcce54cb102c792d468f96/labs/item/item.ts#L29-L37 and
 * https://github.com/material-components/material-web/blob/2f150d28414c7b2757bcce54cb102c792d468f96/labs/item/item.ts#L58-L59.
 */
@ExperimentalComposeHtmlMaterialApi
interface IMdItemScope {
    val elementScope: ElementScope<HTMLElement>

    @ExperimentalComposeHtmlMaterialApi
    enum class Slot(val value: String) {
        Headline("headline"),
        SupportingText("supporting-text"),
        TrailingSupportingText("trailing-supporting-text"),
        Start("start"),
        End("end"),
        Container("container"),
        Overline("overline")
    }

    @ExperimentalComposeHtmlMaterialApi
    fun AttrsScope<*>.slot(slot: Slot) =
        slot(slot.value)
}