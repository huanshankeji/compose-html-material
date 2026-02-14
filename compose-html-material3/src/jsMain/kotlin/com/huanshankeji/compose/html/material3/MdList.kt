package com.huanshankeji.compose.html.material3

import com.huanshankeji.compose.html.material3.imports.*

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.ext.disabled
import com.huanshankeji.compose.web.attributes.ext.href
import com.huanshankeji.compose.web.attributes.ext.target
import com.huanshankeji.compose.web.attributes.ext.type
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/material-components/material-web/blob/main/docs/components/list.md
https://material-web.dev/components/list/
https://material-web.dev/components/list/stories/
 */

@Composable
fun MdList(attrs: Attrs<HTMLElement>? = null, content: @Composable MdListScope.() -> Unit) {
    ListImport // Load the web component

    TagElement("md-list", attrs) {
        MdListScope(this).content()
    }
}

class MdListScope(val elementScope: ElementScope<HTMLElement>) {
    @Composable
    fun MdListItem(
        disabled: Boolean? = null,
        type: MdListItemType? = null,
        href: String? = null,
        target: String? = null,
        attrs: Attrs<HTMLElement>? = null,
        content: @Composable MdListItemScope.() -> Unit
    ) =
        @OptIn(ExposedMdListApi::class)
        com.huanshankeji.compose.html.material3.MdListItem(disabled, type, href, target, attrs, content)
}


@RequiresOptIn(
    "An `MdListItem` is usually in an `MdList`. This component is exposed and should be used carefully. In most cases try to use the one in `MdListScope` instead.",
    RequiresOptIn.Level.WARNING
)
@Retention(AnnotationRetention.BINARY)
annotation class ExposedMdListApi

@ExposedMdListApi
@Composable
fun MdListItem(
    disabled: Boolean? = null,
    type: MdListItemType? = null,
    href: String? = null,
    target: String? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable MdListItemScope.() -> Unit
) {
    ListItemImport // Load the web component

    //@Suppress("RemoveExplicitTypeArguments")
    TagElement<HTMLElement>("md-list-item", {
        disabled(disabled)
        type(type?.stringValue)
        href(href)
        target(target)

        attrs?.invoke(this)
    }) {
        MdListItemScope(this).content()
    }
}

enum class MdListItemType(val stringValue: String) {
    Text("text"), Link("link"), Button("button")
}

class MdListItemScope(val elementScope: ElementScope<HTMLElement>) {
    enum class Slot(val stringValue: String) {
        Headline("headline"),
        Start("start"), End("end"),
        SupportingText("supporting-text"), TrailingSupportingText("trailing-supporting-text"),
        Overline("overline")
    }

    fun AttrsScope<*>.slot(value: Slot) =
        slot(value.stringValue)
}
