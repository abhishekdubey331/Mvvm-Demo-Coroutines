package com.demo.demomeow.presentation

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.demo.demomeow.R

fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .centerCrop()
        .into(this)
}

fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    val toastRoot = View.inflate(this, R.layout.custom_toast, null)
    val textView = toastRoot.findViewById(R.id.my_custom_toast) as TextView
    textView.text = text
    val toast = Toast(this)
    toast.view = toastRoot
    toast.duration = duration
    toast.show()
}

fun <T> LiveData<T>.nonNull(): NonNullMediatorLiveData<T> {
    val mediator: NonNullMediatorLiveData<T> = NonNullMediatorLiveData()
    mediator.addSource(this) { it?.let { mediator.value = it } }
    return mediator
}

inline fun <T: Any> T?.withNotNull(func: T.() -> Unit): T? =
    this?.apply(func)

inline fun <R> R?.orElse(block: () -> R): R {
    return this ?: block()
}

class NonNullMediatorLiveData<T> : MediatorLiveData<T>()
