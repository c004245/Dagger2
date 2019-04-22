package com.playgilround.schedule.client.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.playgilround.schedule.client.dagger2.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
