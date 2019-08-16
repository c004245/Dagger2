package com.example.architecture.ui.details

import android.os.Bundle
import android.os.PersistableBundle
import com.example.architecture.R
import com.example.architecture.base.BaseActivity

class DetailsActivity: BaseActivity(), DetailsContract.View {

    companion object {
        const val REPOSITORY_KEY = "REPOSITORY_KEY"


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
