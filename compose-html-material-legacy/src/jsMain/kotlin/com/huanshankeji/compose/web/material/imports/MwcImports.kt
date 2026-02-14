package com.huanshankeji.compose.web.material.imports

/**
 * Side-effect imports for Material Web Components (legacy MWC).
 * These objects trigger the import of the corresponding JavaScript modules
 * which register the custom elements (web components).
 *
 * When using ES2015 modules, these declarations cause the Kotlin/JS compiler
 * to emit ES6 `import` statements instead of CommonJS `require()` calls.
 */

@JsModule("@material/mwc-button")
@JsNonModule
external object MwcButtonImport

@JsModule("@material/mwc-textfield")
@JsNonModule
external object MwcTextFieldImport

@JsModule("@material/mwc-select")
@JsNonModule
external object MwcSelectImport

@JsModule("@material/mwc-list/mwc-list-item")
@JsNonModule
external object MwcListItemImport

@JsModule("@material/mwc-snackbar")
@JsNonModule
external object MwcSnackbarImport

@JsModule("@material/mwc-circular-progress")
@JsNonModule
external object MwcCircularProgressImport

@JsModule("@material/mwc-circular-progress-four-color")
@JsNonModule
external object MwcCircularProgressFourColorImport
