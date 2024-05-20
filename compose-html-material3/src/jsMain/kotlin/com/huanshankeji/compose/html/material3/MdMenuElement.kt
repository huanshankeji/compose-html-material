package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import com.huanshankeji.compose.web.attributes.Attrs
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.*
import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.EventTarget

/*
https://github.com/material-components/material-web/blob/main/docs/components/menu.md
https://material-web.dev/components/menu/
https://material-web.dev/components/menu/stories/
 */


private fun AttrsScope<HTMLElement>.anchorCorner(anchorCorner: String?) {
    attrIfNotNull("anchor-corner", anchorCorner)
}

private fun AttrsScope<HTMLElement>.menuCorner(menuCorner: String?) {
    attrIfNotNull("menu-corner", menuCorner)
}


// made abstract so there is no need to add the implemented methods
@JsModule("@material/web/menu/menu.js")
@JsName("MdMenu")
abstract external class MdMenuElement : HTMLElement {
    var anchorElement: HTMLElement?
    // ...
}

@Composable
fun MdMenu(
    anchor: String? = null,
    positioning: String? = null,
    quick: Boolean? = null,
    hasOverflow: Boolean? = null,
    open: Boolean? = null,
    // see https://stackoverflow.com/questions/4308989/are-the-decimal-places-in-a-css-width-respected
    xOffset: Number? = null,
    yOffset: Number? = null,
    typeheadDelay: Number? = null,
    anchorCorner: String? = null,
    menuCorner: String? = null,
    stayOpenOnOutsideClick: Boolean? = null,
    stayOpenOnFocusout: Boolean? = null,
    skipRestoreFocus: Boolean? = null,
    defaultFocus: Boolean? = null,
    attrs: Attrs<MdMenuElement>? = null,
    content: @Composable ElementScope<MdMenuElement>.() -> Unit
) {
    require("@material/web/menu/menu.js")

    TagElement<MdMenuElement>("md-menu", {
        attrIfNotNull("anchor", anchor)
        attrIfNotNull("positioning", positioning)
        attrIfNotNull("quick", quick)
        attrIfNotNull("has-overflow", hasOverflow)
        attrIfNotNull("open", open)
        attrIfNotNull("x-offset", xOffset)
        attrIfNotNull("y-offset", yOffset)
        attrIfNotNull("typehead-delay", typeheadDelay)
        anchorCorner(anchorCorner)
        menuCorner(menuCorner)
        attrIfNotNull("stay-open-on-outside-click", stayOpenOnOutsideClick)
        attrIfNotNull("stay-open-on-focusout", stayOpenOnFocusout)
        attrIfNotNull("skip-restore-focus", skipRestoreFocus)
        attrIfNotNull("default-focus", defaultFocus)

        attrs?.invoke(this)
    }) {
        content()
    }
}

// events

fun <T : SyntheticEvent<out EventTarget>> AttrsScope<MdMenuElement>.onOpening(listener: (T) -> Unit) =
    addEventListener("opening", listener)

fun <T : SyntheticEvent<out EventTarget>> AttrsScope<MdMenuElement>.onOpened(listener: (T) -> Unit) =
    addEventListener("opened", listener)

fun <T : SyntheticEvent<out EventTarget>> AttrsScope<MdMenuElement>.onClosing(listener: (T) -> Unit) =
    addEventListener("closing", listener)

fun <T : SyntheticEvent<out EventTarget>> AttrsScope<MdMenuElement>.onClosed(listener: (SyntheticEvent<EventTarget>) -> Unit) =
    addEventListener("closed", listener)

class MdMenuArgs(
    val anchor: String? = null,
    val positioning: String? = null,
    val quick: Boolean? = null,
    val hasOverflow: Boolean? = null,
    val open: Boolean? = null,
    val xOffset: Int? = null,
    val yOffset: Int? = null,
    val typeheadDelay: Number? = null,
    val anchorCorner: String? = null,
    val menuCorner: String? = null,
    val stayOpenOnOutsideClick: Boolean? = null,
    val stayOpenOnFocusout: Boolean? = null,
    val skipRestoreFocus: Boolean? = null,
    val defaultFocus: Boolean? = null,
    val attrs: Attrs<HTMLElement>? = null,
    val content: @Composable ElementScope<HTMLElement>.() -> Unit
)


@Composable
fun MdMenuItem(
    disabled: Boolean? = null,
    type: String? = null,
    href: String? = null,
    target: String? = null,
    keepOpen: Boolean? = null,
    selected: Boolean? = null,
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable MdMenuItemScope.() -> Unit
) {
    require("@material/web/menu/menu-item.js")

    TagElement<HTMLElement>("md-menu-item", {
        disabled(disabled)
        type(type)
        href(href)
        target(target)
        attrIfNotNull("keep-open", keepOpen)
        selected(selected)

        attrs?.invoke(this)
    }) {
        MdMenuItemScope(this).content()
    }
}

class MdMenuItemScope(val elementScope: ElementScope<HTMLElement>) {
    enum class Slot(val stringValue: String) {
        Headline("headline"), Start("start"), End("end")
    }

    fun AttrsScope<*>.slot(value: Slot) =
        slot(value.stringValue)
}

class MdMenuItemArgs(
    val disabled: Boolean? = null,
    val type: String? = null,
    val href: String? = null,
    val target: String? = null,
    val keepOpen: Boolean? = null,
    val selected: Boolean? = null,
    val attrs: Attrs<HTMLElement>? = null,
    val content: @Composable MdMenuItemScope.() -> Unit
)


@Composable
fun MdSubMenu(
    anchorCorner: String? = null,
    menuCorner: String? = null,
    hoverOpenDelay: Number? = null,
    hoverCloseDelay: Number? = null,
    //isSubMenu : Boolean? = null, // `md-sub-menu`, read-only
    attrs: Attrs<HTMLElement>? = null,
    content: @Composable MdSubMenuScope.() -> Unit
) {
    require("@material/web/menu/sub-menu.js")

    TagElement<HTMLElement>("md-sub-menu", {
        anchorCorner(anchorCorner)
        menuCorner(menuCorner)
        attrIfNotNull("hover-open-delay", hoverOpenDelay)
        attrIfNotNull("hover-close-delay", hoverCloseDelay)

        attrs?.invoke(this)
    }) {
        MdSubMenuScope(this).content()
    }
}

class MdSubMenuScope(val elementScope: ElementScope<HTMLElement>) {
    enum class Slot(val stringValue: String) {
        Item("item"), Menu("menu")
    }

    fun AttrsScope<*>.slot(value: Slot) =
        slot(value.stringValue)
}

@Composable
fun MdSubMenu(
    anchorCorner: String? = null,
    menuCorner: String? = null,
    hoverOpenDelay: Number? = null,
    hoverCloseDelay: Number? = null,
    //isSubMenu : Boolean? = null, // `md-sub-menu`
    attrs: Attrs<HTMLElement>? = null,
    mdMenuItemArgs: MdMenuItemArgs,
    mdMenuArgs: MdMenuArgs
) =
    MdSubMenu(anchorCorner, menuCorner, hoverOpenDelay, hoverCloseDelay, attrs) {
        with(mdMenuItemArgs) {
            MdMenuItem(disabled, type, href, target, keepOpen, selected, {
                slot(MdSubMenuScope.Slot.Item)

                attrs?.invoke(this)
            }, content)
        }
        with(mdMenuArgs) {
            MdMenu(
                anchor,
                positioning,
                quick,
                hasOverflow,
                open,
                xOffset,
                yOffset,
                typeheadDelay,
                this.anchorCorner,
                this.menuCorner,
                stayOpenOnOutsideClick,
                stayOpenOnFocusout,
                skipRestoreFocus,
                defaultFocus,
                {
                    slot(MdSubMenuScope.Slot.Menu)

                    attrs?.invoke(this)
                },
                content
            )
        }
    }
