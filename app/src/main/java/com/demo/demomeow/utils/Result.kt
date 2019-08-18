package com.demo.demomeow.utils

import com.demo.demomeow.commons.ServerException

sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T?) : Result<T>()
    data class Error(val exception: ServerException) : Result<Nothing>()
}