package com.huanshankeji.compose.html.material3

import com.huanshankeji.compose.web.attributes.slot
import org.jetbrains.compose.web.attributes.AttrsScope

@ExperimentalComposeHtmlMaterialApi
interface ISlot {
    val value: String
}

@ExperimentalComposeHtmlMaterialApi
interface SlotScope<Slot : ISlot> {
    fun AttrsScope<*>.slot(slot: Slot) =
        slot(slot.value)
}
