@file:OptIn(ExperimentalComposeWebApi::class)

package com.huanshankeji.compose.web.material.mwc

import androidx.compose.runtime.*
import androidx.compose.web.events.SyntheticEvent
import com.huanshankeji.compose.web.HTMLElementContent
import com.huanshankeji.compose.web.attributes.attr
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.EventsListenerScope
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.events.SyntheticChangeEvent
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.events.EventTarget
import kotlin.coroutines.resume

open class MwcAttrsScopeBuilder(val htmlAttrsScope: AttrsScope<HTMLElement>) {
    fun attr(attr: String, value: String) {
        htmlAttrsScope.attr(attr, value)
    }

    fun attr(attr: String, isPresent: Boolean = true) {
        htmlAttrsScope.attr(attr, isPresent)
    }

    fun <T : SyntheticEvent<out EventTarget>> addEventListener(eventName: String, listener: (T) -> Unit) =
        htmlAttrsScope.addEventListener(eventName, listener)
}

open class MwcSimpleComponentAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) :
    MwcAttrsScopeBuilder(htmlAttrsScope) {
    fun label(value: String) = attr("label", value)
    fun icon(value: String) = attr("icon", value)
    fun trailingIcon(isPresent: Boolean = true) = attr("trailingIcon", isPresent)
}

open class MwcInputComponentAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) :
    MwcSimpleComponentAttrsScopeBuilder(htmlAttrsScope) {
    fun helper(value: String) = attr("helper", value)
    fun outlined(isPresent: Boolean = true) = attr("outlined", isPresent)
    fun disabled(isPresent: Boolean = true) = attr("disabled", isPresent)

    /**
     * @see androidx.compose.web.attributes.SelectAttrsScope.onChange
     */
    fun onChange(listener: (SyntheticChangeEvent<String?, HTMLSelectElement>) -> Unit) =
        addEventListener(EventsListenerScope.CHANGE, listener)

    fun onChangeWithValue(onValueChange: (String) -> Unit) =
        onChange { onValueChange(it.target.value) }

    fun value(value: String) = attr("value", value)

    fun required(isPresent: Boolean = true) = attr("required", isPresent)
    fun validationMessage(value: String) = attr("validationMessage", value)
    fun requiredWithValidationMessage(validationMessage: String) {
        required()
        validationMessage(validationMessage)
    }
}


// https://github.com/material-components/material-web/tree/master/packages/button

class MwcButtonAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) :
    MwcSimpleComponentAttrsScopeBuilder(htmlAttrsScope) {
    fun outlined(isPresent: Boolean = true) = attr("outlined", isPresent)
    fun raised(isPresent: Boolean = true) = attr("raised", isPresent)
    fun unelevated(isPresent: Boolean = true) = attr("unelevated", isPresent)
    fun dense(isPresent: Boolean = true) = attr("dense", isPresent)
    fun disabled(isPresent: Boolean = true) = attr("disabled", isPresent)
}


@Composable
fun MwcButton(
    mwcAttrs: (MwcButtonAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: HTMLElementContent = null
) =
    TagElement("mwc-button", {
        mwcAttrs?.invoke(MwcButtonAttrsScopeBuilder(this))
        htmlAttrs?.invoke(this)
    }, content)


// https://github.com/material-components/material-web/tree/master/packages/textfield

class MwcTextfieldAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) :
    MwcInputComponentAttrsScopeBuilder(htmlAttrsScope) {
    fun type(value: String) = attr("type", value)
    fun maxLength(value: Int) = attr("maxLength", value.toString())
}


@Composable
fun MwcTextfield(
    mwcAttrs: (MwcTextfieldAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: HTMLElementContent = null
) =
    TagElement("mwc-textfield", {
        mwcAttrs?.invoke(MwcTextfieldAttrsScopeBuilder(this))
        htmlAttrs?.invoke(this)
    }, content)


// https://github.com/material-components/material-web/tree/master/packages/select

class MwcSelectAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) :
    MwcInputComponentAttrsScopeBuilder(htmlAttrsScope) {
    // I am not sure whether `trailingIcon` is supported here.

    fun onSelected(listener: (SyntheticEvent<EventTarget>) -> Unit) =
        htmlAttrsScope.addEventListener("selected", listener)

    fun onSelectedWithIndex(listener: (index: Int) -> Unit) =
        onSelected {
            val index = it.nativeEvent.asDynamic().detail.index as Int
            listener(index)
        }

    // Setting the index property doesn't work
    //fun index(value: Int) = attr("index", value.toString())
}

@Composable
fun MwcSelect(
    mwcAttrs: (MwcSelectAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: HTMLElementContent
    /*content: (@Composable ElementScope<HTMLElement>.(
        DefaultMwcListItem: (content: HTMLElementContent) -> Unit
    ) -> Unit)? = null*/
) =
    TagElement("mwc-select", {
        mwcAttrs?.invoke(MwcSelectAttrsScopeBuilder(this))
        htmlAttrs?.invoke(this)
    }, content)

class MwcListItemAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) :
    MwcSimpleComponentAttrsScopeBuilder(htmlAttrsScope) {
    @Suppress("DeprecatedCallableAddReplaceWith")
    @Deprecated(
        "It's recommended to use the `value` attribute on the parent component."
    )
    fun selected(isPresent: Boolean = true) = attr("selected", isPresent)
    fun value(value: String) = attr("value", value)
    fun graphicEqIcon() = attr("graphic", "icon")
}

@Composable
fun MwcListItem(
    mwcAttrs: (MwcListItemAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: HTMLElementContent = null
) =
    TagElement("mwc-list-item", {
        mwcAttrs?.invoke(MwcListItemAttrsScopeBuilder(this))
        htmlAttrs?.invoke(this)
    }, content)

@Composable
fun MwcSelectWithItems(
    numSelections: Int,
    itemContent: @Composable (Int) -> Unit,
    selectedIndex: Int?, onIndexSelected: (Int?) -> Unit,

    selectAttrs: (MwcSelectAttrsScopeBuilder.() -> Unit)? = null,
    selectHtmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    listItemAttrs: (MwcListItemAttrsScopeBuilder.() -> Unit)? = null,
    listItemHtmlAttrs: AttrBuilderContext<HTMLElement>? = null
) =
    MwcSelect({
        // Setting the index property doesn't work
        //index(selectedIndex?.let { it + 1 } ?: 0)
        value(selectedIndex?.toString() ?: "")

        onSelectedWithIndex {
            onIndexSelected(if (it == 0) null else it - 1)
        }
        selectAttrs?.invoke(this)
    }, selectHtmlAttrs) {
        MwcListItem({
            //value("unselected") // comment this out for `required` and `validationMessage` to work
            listItemAttrs?.invoke(this)
        })

        for (i in 0 until numSelections)
            MwcListItem({
                value(i.toString())
                listItemAttrs?.invoke(this)
            }, listItemHtmlAttrs) {
                itemContent(i)
            }
    }

@Composable
fun MwcSelectWithItemTexts(
    itemTexts: List<String>,
    selectedIndex: Int?, onIndexSelected: (Int?) -> Unit,

    selectAttrs: (MwcSelectAttrsScopeBuilder.() -> Unit)? = null,
    selectHtmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    listItemAttrs: (MwcListItemAttrsScopeBuilder.() -> Unit)? = null,
    listItemHtmlAttrs: AttrBuilderContext<HTMLElement>? = null
) =
    MwcSelectWithItems(
        itemTexts.size, { Text(itemTexts[it]) }, selectedIndex, onIndexSelected,
        selectAttrs, selectHtmlAttrs, listItemAttrs, listItemHtmlAttrs
    )

@Composable
fun <E : Enum<E>> MwcSelectWithEnumItems(
    values: Array<E>, text: (E) -> String = { it.name },
    selected: E?, onSelected: (E?) -> Unit,

    selectAttrs: (MwcSelectAttrsScopeBuilder.() -> Unit)? = null,
    selectHtmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    listItemAttrs: (MwcListItemAttrsScopeBuilder.() -> Unit)? = null,
    listItemHtmlAttrs: AttrBuilderContext<HTMLElement>? = null
) =
    MwcSelectWithItemTexts(
        values.map(text), selected?.ordinal, { onSelected(if (it !== null) values[it] else null) },
        selectAttrs, selectHtmlAttrs, listItemAttrs, listItemHtmlAttrs
    )


class MwcIconButtonAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) : MwcAttrsScopeBuilder(htmlAttrsScope) {
    fun icon(value: String) = attr("icon", value)
    fun disabled(isPresent: Boolean = true) = attr("disabled", isPresent)
    fun ariaLabel(value: String) = attr("aria-label", value)
}

@Composable
fun MwcIconButton(
    mwcAttrs: (MwcIconButtonAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: HTMLElementContent = null
) =
    TagElement("mwc-button", {
        mwcAttrs?.invoke(MwcIconButtonAttrsScopeBuilder(this))
        htmlAttrs?.invoke(this)
    }, content)


// https://github.com/material-components/material-web/tree/master/packages/snackbar

class MwcSnackbarAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) :
    MwcAttrsScopeBuilder(htmlAttrsScope) {
    fun labelText(value: String) = attr("labelText", value)

    fun open(isPresent: Boolean = true) = attr("open", isPresent)
    fun timeoutMs(value: Number) = attr("open", value.toString())
}

class MwcSnackbarElementScopeDelegate(elementScope: ElementScope<HTMLElement>) :
    ElementScope<HTMLElement> by elementScope {
    fun MwcButtonAttrsScopeBuilder.slot(value: String) = attr("slot", value)
    fun MwcIconButtonAttrsScopeBuilder.slot(value: String) = attr("slot", value)
}

@Composable
fun MwcSnackbar(
    mwcAttrs: (MwcSnackbarAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MwcSnackbarElementScopeDelegate.() -> Unit)? = null
) =
    TagElement<HTMLElement>("mwc-snackbar", {
        mwcAttrs?.invoke(MwcSnackbarAttrsScopeBuilder(this))
        htmlAttrs?.invoke(this)
    }) {
        content?.invoke(MwcSnackbarElementScopeDelegate(this))
    }

@Composable
fun OpenMwcSnackbar(
    open: Boolean = true,
    mwcAttrs: (MwcSnackbarAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MwcSnackbarElementScopeDelegate.() -> Unit)? = null
) =
    MwcSnackbar({
        if (open) open()
        mwcAttrs?.invoke(this)
    }, htmlAttrs, content)

/**
 * Use with [snackbarShow].
 */
@Composable
fun MwcSnackbarWithRef(
    setRef: (HTMLElement?) -> Unit,

    mwcAttrs: (MwcSnackbarAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MwcSnackbarElementScopeDelegate.() -> Unit)? = null
) =
    MwcSnackbar(mwcAttrs, {
        ref {
            setRef(it)
            onDispose { setRef(null) }
        }
        htmlAttrs?.invoke(this)
    }, content)

fun HTMLElement.snackbarShow() =
    asDynamic().show()

fun HTMLElement.snackbarShow(labelText: String) {
    setAttribute("labelText", labelText)
    snackbarShow()
}


// follows the Jetpack Compose way
// see: https://android.googlesource.com/platform/frameworks/support/+/androidx-main/compose/material/material/src/commonMain/kotlin/androidx/compose/material/SnackbarHost.kt

@Stable
class SnackbarHostState {
    private val mutex = Mutex()

    var currentSnackbarData by mutableStateOf<SnackbarData?>(null)
        private set

    suspend fun showSnackbar(
        message: String
    ): SnackbarResult = mutex.withLock {
        try {
            return suspendCancellableCoroutine {
                currentSnackbarData = SnackbarData(message, it)
            }
        } finally {
            currentSnackbarData = null
        }
    }

    fun mainLaunchShowSnackbar(message: String) =
        MainScope().launch { showSnackbar(message) }

    fun mainAsyncShowSnackbar(message: String) =
        MainScope().async { showSnackbar(message) }
}

@Stable
data class SnackbarData(
    val message: String,
    val continuation: CancellableContinuation<SnackbarResult>
)

typealias SnackbarResult = Unit

@Composable
fun MwcSnackbarHost(
    hostState: SnackbarHostState,
    mwcAttrs: (MwcSnackbarAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MwcSnackbarElementScopeDelegate.() -> Unit)? = null
) {
    val currentSnackbarData = hostState.currentSnackbarData

    MwcSnackbar({
        currentSnackbarData?.let { labelText(it.message) }
        mwcAttrs?.invoke(this)
    }, htmlAttrs) {
        DisposableEffect(currentSnackbarData) {
            if (currentSnackbarData !== null) {
                scopeElement.snackbarShow()
                scopeElement.addEventListener("MDCSnackbar:closed", {
                    currentSnackbarData.continuation.run {
                        if (isActive) resume(Unit)
                    }
                })
            }

            onDispose { }
        }

        content?.invoke(this)
    }
}

@Composable
fun MwcSnackbarHostWithCloseButton(snackbarHostState: SnackbarHostState) =
    MwcSnackbarHost(snackbarHostState) {
        MwcIconButton({
            icon("close")
            slot("dismiss")
        })
    }


// see: https://github.com/material-components/material-web/tree/master/packages/circular-progress
// see: https://github.com/material-components/material-web/tree/master/packages/circular-progress-four-color

class MwcCircularProgressAttrsScopeBuilder(htmlAttrsScope: AttrsScope<HTMLElement>) :
    MwcAttrsScopeBuilder(htmlAttrsScope) {
    fun progress(value: CSSNumeric) = attr("progress", value.toString())
    fun indeterminate(isPresent: Boolean = true) = attr("indeterminate", isPresent)
}

@Composable
fun MwcCircularProgress(
    mwcAttrs: (MwcCircularProgressAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null
) =
    TagElement<HTMLElement>("mwc-circular-progress", {
        mwcAttrs?.invoke(MwcCircularProgressAttrsScopeBuilder(this))
        htmlAttrs?.invoke(this)
    }, null)

@Composable
fun MwcCircularProgressFourColor(
    mwcAttrs: (MwcCircularProgressAttrsScopeBuilder.() -> Unit)? = null,
    htmlAttrs: AttrBuilderContext<HTMLElement>? = null
) =
    TagElement<HTMLElement>("mwc-circular-progress-four-color", {
        mwcAttrs?.invoke(MwcCircularProgressAttrsScopeBuilder(this))
        htmlAttrs?.invoke(this)
    }, null)


// TODO: CSS and style
