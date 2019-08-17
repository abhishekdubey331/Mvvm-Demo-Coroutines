package com.demo.demomeow.data.repositories

import com.demo.demomeow.utils.Result
import com.demo.demomeow.data.entities.Cat
import com.demo.demomeow.data.remote.CatApi
import com.demo.demomeow.utils.Constants

interface CatRepository {
    suspend fun getCatsList(): Result<List<Cat>>
}

class CatRepositoryImpl(private val catApi: CatApi) : CatRepository {
    override suspend fun getCatsList(): Result<List<Cat>> {
        return try {
            val result = catApi.getCatsAsync(limit = Constants.NUMBER_OF_CATS).await()
            Result.Success(result)
        } catch (ex: Exception) {
            Result.Error(ex)
        }
    }
}
