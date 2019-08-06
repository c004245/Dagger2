package com.example.repositoryuser.splash

import android.os.Bundle
import com.example.repositoryuser.BaseActivity
import com.example.repositoryuser.GithubApplication
import com.example.repositoryuser.R
import com.jakewharton.rxbinding.widget.RxTextView
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent
import kotlinx.android.synthetic.main.activity_splash.*
import rx.Subscription
import rx.functions.Action1

class SplashActivity: BaseActivity() {

    lateinit var textChangeSubscription: Subscription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        textChangeSubscription = RxTextView.textChangeEvents(etUsername).subscribe({

        })

        }

    override fun onDestroy() {
        super.onDestroy()
        textChangeSubscription.unsubscribe()
    }

    override fun setupActivityComponent() {
        GithubApplication.get
    }




}