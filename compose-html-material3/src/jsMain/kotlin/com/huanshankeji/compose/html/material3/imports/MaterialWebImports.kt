package com.huanshankeji.compose.html.material3.imports

/**
 * Side-effect imports for Material Web components.
 * These objects trigger the import of the corresponding JavaScript modules
 * which register the custom elements (web components).
 *
 * When using ES2015 modules, these declarations cause the Kotlin/JS compiler
 * to emit ES6 `import` statements instead of CommonJS `require()` calls.
 */

// Button imports
@JsModule("@material/web/button/elevated-button.js")
@JsNonModule
external object ElevatedButtonImport

@JsModule("@material/web/button/filled-button.js")
@JsNonModule
external object FilledButtonImport

@JsModule("@material/web/button/filled-tonal-button.js")
@JsNonModule
external object FilledTonalButtonImport

@JsModule("@material/web/button/outlined-button.js")
@JsNonModule
external object OutlinedButtonImport

@JsModule("@material/web/button/text-button.js")
@JsNonModule
external object TextButtonImport

// Card imports
@JsModule("@material/web/labs/card/elevated-card.js")
@JsNonModule
external object ElevatedCardImport

@JsModule("@material/web/labs/card/filled-card.js")
@JsNonModule
external object FilledCardImport

@JsModule("@material/web/labs/card/outlined-card.js")
@JsNonModule
external object OutlinedCardImport

// Checkbox import
@JsModule("@material/web/checkbox/checkbox.js")
@JsNonModule
external object CheckboxImport

// FAB imports
@JsModule("@material/web/fab/fab.js")
@JsNonModule
external object FabImport

@JsModule("@material/web/fab/branded-fab.js")
@JsNonModule
external object BrandedFabImport

// Icon import
@JsModule("@material/web/icon/icon.js")
@JsNonModule
external object IconImport

// Icon button imports
@JsModule("@material/web/iconbutton/icon-button.js")
@JsNonModule
external object IconButtonImport

@JsModule("@material/web/iconbutton/filled-icon-button.js")
@JsNonModule
external object FilledIconButtonImport

@JsModule("@material/web/iconbutton/filled-tonal-icon-button.js")
@JsNonModule
external object FilledTonalIconButtonImport

@JsModule("@material/web/iconbutton/outlined-icon-button.js")
@JsNonModule
external object OutlinedIconButtonImport

// List imports
@JsModule("@material/web/list/list.js")
@JsNonModule
external object ListImport

@JsModule("@material/web/list/list-item.js")
@JsNonModule
external object ListItemImport

// Menu imports
@JsModule("@material/web/menu/menu.js")
@JsNonModule
external object MenuImport

@JsModule("@material/web/menu/menu-item.js")
@JsNonModule
external object MenuItemImport

@JsModule("@material/web/menu/sub-menu.js")
@JsNonModule
external object SubMenuImport

// Navigation imports
@JsModule("@material/web/labs/navigationbar/navigation-bar.js")
@JsNonModule
external object NavigationBarImport

@JsModule("@material/web/labs/navigationtab/navigation-tab.js")
@JsNonModule
external object NavigationTabImport

// Progress imports
@JsModule("@material/web/progress/circular-progress.js")
@JsNonModule
external object CircularProgressImport

@JsModule("@material/web/progress/linear-progress.js")
@JsNonModule
external object LinearProgressImport

// Switch import
@JsModule("@material/web/switch/switch.js")
@JsNonModule
external object SwitchImport

// Text field imports
@JsModule("@material/web/textfield/filled-text-field.js")
@JsNonModule
external object FilledTextFieldImport

@JsModule("@material/web/textfield/outlined-text-field.js")
@JsNonModule
external object OutlinedTextFieldImport
