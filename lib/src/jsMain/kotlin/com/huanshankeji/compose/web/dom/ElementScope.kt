package com.huanshankeji.compose.web.dom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

@Composable
@NonRestartableComposable
fun <TElement : Element> ElementScope<TElement>.LaunchedRefEffect(
    vararg keys: Any?,
    block: suspend CoroutineScope.(TElement) -> Unit
) =
    TODO() as Unit
