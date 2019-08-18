package com.demo.demomeow.presentation.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.demo.demomeow.R
import com.demo.demomeow.presentation.detail.DetailActivity
import com.demo.demomeow.presentation.main.adapter.CatAdapter
import com.demo.demomeow.presentation.withNotNull
import com.demo.demomeow.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.loadingObserver().observe(this, Observer<Boolean> {
            it?.withNotNull {
                mainProgressBar.visibility = if (this) View.VISIBLE else View.GONE
            }
        })
        val onCatClicked: (imageUrl: String) -> Unit = { imageUrl ->
            startActivity(DetailActivity.getStartIntent(this, imageUrl))
        }
        catAdapter = CatAdapter(onCatClicked)
        catsRecyclerView.apply {
            layoutManager = GridLayoutManager(
                this@MainActivity,
                Constants.NUMBER_OF_COLUMNS
            )
            adapter = catAdapter
        }
        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel.catListLivaData().observe(this, Observer {
            it.withNotNull {
                catAdapter.updateData(this)
            }
        })
        mainViewModel.getCatList()
    }
}
