package com.demo.demomeow.commons


import com.demo.demomeow.utils.Constants
import com.demo.demomeow.utils.Result
import com.orhanobut.logger.Logger
import org.json.JSONObject
import retrofit2.Response

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): T? {
        val result: Result<T> = safeApiResult(call)
        var data: T? = null
        when (result) {
            is Result.Success ->
                data = result.data
            is Result.Error -> {
                Logger.d(result.serverError.errorMessage)
            }
        }
        return data
    }

    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>
    ): Result<T> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful) {
                Result.Success(response.body())
            } else {
                Result.Error(ServerError(response.code(), Constants.getErrorMessage(response.errorBody())))
            }
        } catch (exception: Exception) {
            Result.Error(ServerError(Constants.SERVER_DOWN_CODE, Constants.SERVER_DOWN_ERROR))
        }
    }
}
