package com.example.architecture.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecture.R
import com.example.architecture.base.BaseActivity
import com.example.architecture.services.GithubRepoEntity
import com.example.architecture.ui.details.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject lateinit var mainPresenter: MainPresenter

    private var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mainPresenter.attachView(this)
        main_btn.setOnClickListener {
            mainPresenter.loadResults()
        }
    }

    private fun initViews() {
        mainAdapter = MainAdapter { startDetailActivity(it) }
        main_recycler.adapter = mainAdapter
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.detachView()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun hideProgress() {
        main_progress.visibility = View.INVISIBLE
    }

    override fun showResults(results: List<GithubRepoEntity>) {
        mainAdapter?.addAll(results)
    }

    override fun showProgress() {
        main_progress.visibility = View.VISIBLE
    }

    private fun startDetailActivity(it: GithubRepoEntity) {
//        DetailsActivity.getIntent(this, it).startActivity(this)
    }
}
