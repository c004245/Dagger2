package com.example.architecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecture.GithubService
import com.example.architecture.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var githubService: GithubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {

    }
}
