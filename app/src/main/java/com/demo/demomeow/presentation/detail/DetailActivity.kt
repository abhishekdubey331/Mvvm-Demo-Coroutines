package com.demo.demomeow.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.demo.demomeow.R
import com.demo.demomeow.presentation.loadImage
import com.demo.demomeow.utils.Constants
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, imageUrl: String): Intent {
            return Intent(context, DetailActivity::class.java)
                .putExtra(Constants.EXTRA_CAT_IMAGE_URL, imageUrl)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val imageUrl = intent.getStringExtra(Constants.EXTRA_CAT_IMAGE_URL)
        detailCatImage.loadImage(imageUrl)
    }
}