package com.demo.demomeow.data.remote

import com.demo.demomeow.data.entities.Cat
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {

    @GET("images/searc")
    fun getCatsAsync(@Query("limit") limit: Int)
            : Deferred<Response<List<Cat>>>
}