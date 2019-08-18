package com.demo.demomeow.data.remote

import com.demo.demomeow.data.entities.Cat
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    /* Get route used to retrieve cat images, limit is the number of cats item */
    @GET("images/search")
    fun getCatsAsync(@Query("limit") limit: Int)
            : Deferred<Response<List<Cat>>>

}