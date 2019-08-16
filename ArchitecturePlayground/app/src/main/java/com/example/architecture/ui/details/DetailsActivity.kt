package com.example.architecture.ui.details

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.example.architecture.R
import com.example.architecture.base.BaseActivity
import com.example.architecture.services.GithubRepoEntity
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity: BaseActivity(), DetailsContract.View {

    companion object {
        const val REPOSITORY_KEY = "REPOSITORY_KEY"

        fun getIntent(originActivity: Activity, repository: GithubRepoEntity): Intent {
            val intent = Intent(originActivity, DetailsActivity::class.java)
            intent.putExtra(REPOSITORY_KEY, repository)
            return intent
        }
    }

    @Inject lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        detailsPresenter.attachView(this)

        val githubRepoEntity = intent.getParcelableExtra<GithubRepoEntity>(REPOSITORY_KEY)

        detailsPresenter.initData(githubRepoEntity)
        details_btn.setOnClickListener {
            detailsPresenter.onGoToRepositoryClicked()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        detailsPresenter.detachView()
    }

    override fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun setUrlAddress(url: String) {
        details_txt.text = url
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun startUrl(url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).startActivity(this)
    }
}
