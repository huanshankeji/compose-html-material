package com.huanshankeji.compose.html.material3.maicol07.materialwebadditions

import androidx.compose.runtime.Composable
import com.huanshankeji.compose.html.material3.ExperimentalComposeHtmlMaterialApi
import com.huanshankeji.compose.html.material3.ISlot
import com.huanshankeji.compose.html.material3.SlotScope
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement

/*
https://github.com/maicol07/material-web-additions/blob/main/docs/components/top-app-bar.md
https://material-web-additions.maicol07.it/components/top-app-bar/
https://m3.material.io/components/top-app-bar
*/

@JsModule("@maicol07/material-web-additions/top-app-bar/small-top-app-bar.js")
private external object SmallTopAppBarImport

@JsModule("@maicol07/material-web-additions/top-app-bar/center-aligned-top-app-bar.js")
private external object CenterAlignedTopAppBarImport

@JsModule("@maicol07/material-web-additions/top-app-bar/medium-top-app-bar.js")
private external object MediumTopAppBarImport

@JsModule("@maicol07/material-web-additions/top-app-bar/large-top-app-bar.js")
private external object LargeTopAppBarImport

@Composable
private fun CommonMdTopAppBar(
    tagName: String,
    sticky: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable MdTopAppBarScope.() -> Unit
) {
    TagElement(tagName, {
        attrIfNotNull("sticky", sticky)

        attrs?.invoke(this)
    }) {
        MdTopAppBarScope(this).content()
    }
}

@MaterialWebAdditionsApi
@Composable
fun MdSmallTopAppBar(
    sticky: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable MdTopAppBarScope.() -> Unit
) {
    SmallTopAppBarImport // Load the web component
    CommonMdTopAppBar("md-small-top-app-bar", sticky, attrs, content)
}

@MaterialWebAdditionsApi
@Composable
fun MdCenterAlignedTopAppBar(
    sticky: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable MdTopAppBarScope.() -> Unit
) {
    CenterAlignedTopAppBarImport // Load the web component
    CommonMdTopAppBar("md-center-aligned-top-app-bar", sticky, attrs, content)
}

@MaterialWebAdditionsApi
@Composable
fun MdMediumTopAppBar(
    sticky: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable MdTopAppBarScope.() -> Unit
) {
    MediumTopAppBarImport // Load the web component
    CommonMdTopAppBar("md-medium-top-app-bar", sticky, attrs, content)
}

@MaterialWebAdditionsApi
@Composable
fun MdLargeTopAppBar(
    sticky: Boolean? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: @Composable MdTopAppBarScope.() -> Unit
) {
    LargeTopAppBarImport // Load the web component
    CommonMdTopAppBar("md-large-top-app-bar", sticky, attrs, content)
}

// https://github.com/maicol07/material-web-additions/blob/main/top-app-bar/internal/top-app-bar.ts
@ExperimentalComposeHtmlMaterialApi
class MdTopAppBarScope(val elementScope: ElementScope<HTMLElement>) : SlotScope<MdTopAppBarScope.Slot> {
    enum class Slot(override val value: String) : ISlot {
        Start("start"),
        End("end")
    }
}
