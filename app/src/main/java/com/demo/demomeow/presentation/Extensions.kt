package com.demo.demomeow.presentation

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