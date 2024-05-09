package com.huanshankeji.compose.web

@RequiresOptIn(
    "You are recommend to use the similar layout APIs in Kobweb Compose. See \"https://github.com/varabyte/kobweb/tree/main/frontend/kobweb-compose/src/jsMain/kotlin/com/varabyte/kobweb/compose/foundation/layout\".",
    RequiresOptIn.Level.WARNING
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
annotation class PreferringKobwebComposeLayoutApi