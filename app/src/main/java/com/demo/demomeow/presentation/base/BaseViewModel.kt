package com.demo.demomeow.presentation.base

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    companion object {
        val showLoading = MutableLiveData<Boolean>()
    }

    fun loadingObserver(): LiveData<Boolean> {
        return showLoading
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
