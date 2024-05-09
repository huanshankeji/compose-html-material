package com.huanshankeji.compose.web

sealed class LoadingState<out T, out E> {
    object Loading : LoadingState<Nothing, Nothing>()
    class Loaded<out T>(val value: T) : LoadingState<T, Nothing>()
    class Error<out E>(val error: E) : LoadingState<Nothing, E>()
}

typealias ThrowableErrorLoadingState<T> = LoadingState<T, Throwable>
typealias StringErrorLoadingState<T> = LoadingState<T, String>
