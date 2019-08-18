package com.demo.demomeow.data.repositories

import com.demo.demomeow.commons.BaseRepository
import com.demo.demomeow.data.entities.Cat
import com.demo.demomeow.data.remote.CatApi
import com.demo.demomeow.utils.Constants


class CatRepository(private val catApi: CatApi) : BaseRepository() {


    suspend fun getCatsList(): List<Cat>? {
        return safeApiCall(
            call = { catApi.getCatsAsync(limit = Constants.NUMBER_OF_CATS).await() }
        )
    }
}

