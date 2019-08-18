package com.demo.demomeow.presentation.main

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

    val showLoading = MutableLiveData<Boolean>()
    val catsList = MutableLiveData<List<Cat>>()
    val showError = SingleLiveEvent<String>()

    init {
        loadCats()
    }

    private fun loadCats() {
        showLoading.value = true
        launch {
            val result = withContext(Dispatchers.IO) { catRepository.getCatsList() }
            showLoading.value = false
            when (result) {
                is Result.Success -> catsList.value = result.data
                is Result.Error -> showError.value = result.serverError.message
            }
        }
    }
}
