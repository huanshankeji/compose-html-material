package com.huanshankeji.compose.html.material3

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import com.huanshankeji.compose.html.material3.attributes.commonOnClosed
import com.huanshankeji.compose.html.material3.attributes.commonOnClosing
import com.huanshankeji.compose.html.material3.attributes.commonOnOpened
import com.huanshankeji.compose.html.material3.attributes.commonOnOpening
import com.huanshankeji.compose.web.attributes.attrIfNotNull
import com.huanshankeji.compose.web.attributes.ext.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.EventTarget

/*
https://github.com/material-components/material-web/blob/main/docs/components/menu.md
https://material-web.dev/components/menu/
https://material-web.dev/components/menu/stories/
https://m3.material.io/components/menus/overview
 */

@JsModule("@material/web/menu/menu.js")
private external object MenuImport

@JsModule("@material/web/menu/menu-item.js")
private external object MenuItemImport

@JsModule("@material/web/menu/sub-menu.js")
private external object SubMenuImport

enum class MenuPositioning(val value: String) {
    Absolute("absolute"), Fixed("fixed"), Popover("popover")
}

enum class MenuCorner(val value: String) {
    StartStart("START_START"),
    StartEnd("START_END"),
    EndStart("END_START"),
    EndEnd("END_END")
}

enum class MenuDefaultFocus(val value: String) {
    None("none"), ListRoot("list-root"), FirstItem("first-item"), LastItem("last-item")
}

enum class MenuItemType(val value: String) {
    MenuItem("menuitem"), Option("option"), Button("button"), Link("link")
}

private fun AttrsScope<HTMLElement>.anchorCorner(anchorCorner: MenuCorner?) {
    attrIfNotNull("anchor-corner", anchorCorner?.value)
}

private fun AttrsScope<HTMLElement>.menuCorner(menuCorner: MenuCorner?) {
    attrIfNotNull("menu-corner", menuCorner?.value)
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
    positioning: MenuPositioning? = null,
    quick: Boolean? = null,
    hasOverflow: Boolean? = null,
    open: Boolean? = null,
    // see https://stackoverflow.com/questions/4308989/are-the-decimal-places-in-a-css-width-respected
    xOffset: Number? = null,
    yOffset: Number? = null,
    typeaheadDelay: Number? = null,
    anchorCorner: MenuCorner? = null,
    menuCorner: MenuCorner? = null,
    stayOpenOnOutsideClick: Boolean? = null,
    stayOpenOnFocusout: Boolean? = null,
    skipRestoreFocus: Boolean? = null,
    defaultFocus: MenuDefaultFocus? = null,
    attrs: AttrBuilderContext<MdMenuElement>? = null,
    content: @Composable (ElementScope<MdMenuElement>.() -> Unit)? = null
) {
    MenuImport // Load the web component

    TagElement<MdMenuElement>("md-menu", {
        attrIfNotNull("anchor", anchor)
        attrIfNotNull("positioning", positioning?.value)
        attrIfNotNull("quick", quick)
        attrIfNotNull("has-overflow", hasOverflow)
        attrIfNotNull("open", open)
        attrIfNotNull("x-offset", xOffset)
        attrIfNotNull("y-offset", yOffset)
        attrIfNotNull("typeahead-delay", typeaheadDelay)
        anchorCorner(anchorCorner)
        menuCorner(menuCorner)
        attrIfNotNull("stay-open-on-outside-click", stayOpenOnOutsideClick)
        attrIfNotNull("stay-open-on-focusout", stayOpenOnFocusout)
        attrIfNotNull("skip-restore-focus", skipRestoreFocus)
        attrIfNotNull("default-focus", defaultFocus?.value)

        attrs?.invoke(this)
    }) {
        content?.invoke(this)
    }
}

// events

fun <T : SyntheticEvent<out EventTarget>> AttrsScope<MdMenuElement>.onOpening(listener: (T) -> Unit) =
    commonOnOpening(listener)

fun <T : SyntheticEvent<out EventTarget>> AttrsScope<MdMenuElement>.onOpened(listener: (T) -> Unit) =
    commonOnOpened(listener)

fun <T : SyntheticEvent<out EventTarget>> AttrsScope<MdMenuElement>.onClosing(listener: (T) -> Unit) =
    commonOnClosing(listener)

fun <T : SyntheticEvent<out EventTarget>> AttrsScope<MdMenuElement>.onClosed(listener: (T) -> Unit) =
    commonOnClosed(listener)

class MdMenuArgs(
    val anchor: String? = null,
    val positioning: MenuPositioning? = null,
    val quick: Boolean? = null,
    val hasOverflow: Boolean? = null,
    val open: Boolean? = null,
    val xOffset: Int? = null,
    val yOffset: Int? = null,
    val typeheadDelay: Number? = null,
    val anchorCorner: MenuCorner? = null,
    val menuCorner: MenuCorner? = null,
    val stayOpenOnOutsideClick: Boolean? = null,
    val stayOpenOnFocusout: Boolean? = null,
    val skipRestoreFocus: Boolean? = null,
    val defaultFocus: MenuDefaultFocus? = null,
    val attrs: AttrBuilderContext<HTMLElement>? = null,
    val content: ContentBuilder<HTMLElement>
)


/*
https://github.com/material-components/material-web/blob/main/docs/components/menu.md#mdmenuitem-md-menu-item
https://github.com/material-components/material-web/blob/516cbc02bf770b7c3c5c6b546f1e5d81939b9f23/menu/internal/menuitem/menu-item.ts#L43-L72
https://github.com/material-components/material-web/blob/516cbc02bf770b7c3c5c6b546f1e5d81939b9f23/menu/internal/menuitem/menu-item.ts#L83-L94
 */
@Composable
fun MdMenuItem(
    disabled: Boolean? = null,
    type: MenuItemType? = null,
    href: String? = null,
    target: String? = null,
    keepOpen: Boolean? = null,
    selected: Boolean? = null,
    typeaheadText: String? = null,
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdMenuItemScope.() -> Unit)? = null
) {
    MenuItemImport // Load the web component

    TagElement("md-menu-item", {
        disabled(disabled)
        type(type?.value)
        href(href)
        target(target)
        attrIfNotNull("keep-open", keepOpen)
        selected(selected)
        attrIfNotNull("typeahead-text", typeaheadText)

        attrs?.invoke(this)
    }) {
        content?.let { MdMenuItemScope(this).it() }
    }
}

class MdMenuItemScope(override val elementScope: ElementScope<HTMLElement>) : IMdItemScope

class MdMenuItemArgs(
    val disabled: Boolean? = null,
    val type: MenuItemType? = null,
    val href: String? = null,
    val target: String? = null,
    val keepOpen: Boolean? = null,
    val selected: Boolean? = null,
    val typeaheadText: String? = null,
    val attrs: AttrBuilderContext<HTMLElement>? = null,
    val content: @Composable MdMenuItemScope.() -> Unit
)


@Composable
fun MdSubMenu(
    anchorCorner: MenuCorner? = null,
    menuCorner: MenuCorner? = null,
    hoverOpenDelay: Number? = null,
    hoverCloseDelay: Number? = null,
    //isSubMenu : Boolean? = null, // `md-sub-menu`, read-only
    attrs: AttrBuilderContext<HTMLElement>? = null,
    content: (@Composable MdSubMenuScope.() -> Unit)? = null
) {
    SubMenuImport // Load the web component

    TagElement<HTMLElement>("md-sub-menu", {
        anchorCorner(anchorCorner)
        menuCorner(menuCorner)
        attrIfNotNull("hover-open-delay", hoverOpenDelay)
        attrIfNotNull("hover-close-delay", hoverCloseDelay)

        attrs?.invoke(this)
    }) {
        content?.let { MdSubMenuScope(this).it() }
    }
}

class MdSubMenuScope(val elementScope: ElementScope<HTMLElement>) : SlotScope<MdSubMenuScope.Slot> {
    enum class Slot(override val value: String) : ISlot {
        Item("item"), Menu("menu")
    }
}

@Composable
fun MdSubMenu(
    anchorCorner: MenuCorner? = null,
    menuCorner: MenuCorner? = null,
    hoverOpenDelay: Number? = null,
    hoverCloseDelay: Number? = null,
    //isSubMenu : Boolean? = null, // `md-sub-menu`
    attrs: AttrBuilderContext<HTMLElement>? = null,
    mdMenuItemArgs: MdMenuItemArgs,
    mdMenuArgs: MdMenuArgs
) =
    MdSubMenu(anchorCorner, menuCorner, hoverOpenDelay, hoverCloseDelay, attrs) {
        with(mdMenuItemArgs) {
            MdMenuItem(disabled, type, href, target, keepOpen, selected, typeaheadText, {
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
