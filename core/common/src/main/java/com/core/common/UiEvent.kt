package com.core.common

sealed class UiEvent<T>(
    val data: T? = null, val message: String? = null
) {

    class Success<T>(data: T?) : UiEvent<T>(data = data)
    class Error<T>(errorMessage: String = "Unidentified error ", data: T? = null) :
        UiEvent<T>(data = data, message = errorMessage)

    class Loading<T> : UiEvent<T>()
}
