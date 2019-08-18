package com.demo.demomeow.commons


import com.demo.demomeow.utils.Result
import com.orhanobut.logger.Logger
import okhttp3.ResponseBody
import retrofit2.Response


open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): T? {
        val result: Result<T> = safeApiResult(call)
        var data: T? = null
        when (result) {
            is Result.Success ->
                data = result.data
            is Result.Error -> {
                Logger.d(result.exception)
            }
        }
        return data
    }

    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>
    ): Result<T> {
        val response = call.invoke()
        return if (response.isSuccessful) {
            Result.Success(response.body())
        } else {
            val error: ResponseBody? = response.errorBody()
            Result.Error(Exception(response.code()))
        }
    }
}
