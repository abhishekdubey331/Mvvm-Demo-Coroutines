package com.demo.demomeow.utils

import com.demo.demomeow.commons.ServerError

sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T?) : Result<T>()
    data class Error(val serverError: ServerError) : Result<Nothing>()
}