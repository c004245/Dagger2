package com.example.architecture.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecture.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var mainPresenter: MainPresenter

    private var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        mainAdapter = MainAdapter { }

    }
}
