package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

internal fun <T : Element, ComponentScope> (@Composable ComponentScope.() -> Unit)?.toElementScopeContentBuilder(
    scopeConstructor: (ElementScope<T>) -> ComponentScope
): ContentBuilder<T>? =
    this?.let { { scopeConstructor(this).it() } }
