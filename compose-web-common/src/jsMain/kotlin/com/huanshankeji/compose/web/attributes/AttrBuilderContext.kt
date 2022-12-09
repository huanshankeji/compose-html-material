package com.huanshankeji.compose.web.attributes

import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.w3c.dom.Element

operator fun <TElement : Element> AttrBuilderContext<TElement>.plus(other: AttrBuilderContext<TElement>?): AttrBuilderContext<TElement> =
    if (other === null) this
    else {
        {
            this@plus()
            other()
        }
    }

/** A helper function to create [AttrBuilderContext]s where type inference doesn't work */
@Suppress("NOTHING_TO_INLINE")
inline fun <TElement : Element> attrs(noinline attrs: AttrBuilderContext<TElement>) =
    attrs
