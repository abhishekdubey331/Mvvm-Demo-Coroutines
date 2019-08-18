package com.demo.demomeow.presentation.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.demo.demomeow.utils.SingleLiveEvent
import com.demo.demomeow.data.entities.Cat
import com.demo.demomeow.data.repositories.CatRepository
import com.demo.demomeow.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import com.demo.demomeow.utils.Result
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val catRepository: CatRepository) : BaseViewModel() {

    private val catsList = MutableLiveData<List<Cat>>()

    fun catListLivaData(): LiveData<List<Cat>> {
        return catsList
    }

    fun getCatList() {
        launch {
            val result = withContext(Dispatchers.IO) { catRepository.getCatsList() }
            catsList.value = result
        }
    }
}
