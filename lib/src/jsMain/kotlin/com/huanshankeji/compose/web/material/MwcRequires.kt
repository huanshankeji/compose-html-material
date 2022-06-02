package com.huanshankeji.compose.web.material

external fun require(module: String): dynamic

fun mwcRequires() {
    require("@material/mwc-button")
    require("@material/mwc-textfield")
    require("@material/mwc-select")
    require("@material/mwc-list/mwc-list-item")
    require("@material/mwc-snackbar")
    require("@material/mwc-circular-progress")
    require("@material/mwc-circular-progress-four-color")
}
