package com.demo.demomeow.presentation.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.demo.demomeow.R
import com.demo.demomeow.presentation.detail.DetailActivity
import com.demo.demomeow.presentation.main.adapter.CatAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

const val NUMBER_OF_COLUMN = 3

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val onCatClicked: (imageUrl: String) -> Unit = { imageUrl ->
            startActivity(DetailActivity.getStartIntent(this, imageUrl))
        }
        catAdapter = CatAdapter(onCatClicked)
        catsRecyclerView.apply {
            layoutManager = GridLayoutManager(
                this@MainActivity,
                NUMBER_OF_COLUMN
            )
            adapter = catAdapter
        }
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.catsList.observe(this, Observer { newCatsList ->
            catAdapter.updateData(newCatsList!!)
        })

        viewModel.showLoading.observe(this, Observer { showLoading ->
            showLoading?.let {
                if (it)
                    mainProgressBar.visibility = View.VISIBLE
                else
                    mainProgressBar.visibility = View.GONE
            }
        })
    }
}
