package com.demo.demomeow.presentation

import android.widget.ImageView
import com.bumptech.glide.Glide

// This extension allow to call a function directly on the View to load an image.
fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .centerCrop()
        .into(this)
}

val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }
