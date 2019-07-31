package com.playgilround.schedule.client.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.playgilround.schedule.client.dagger2.presenter.MainPresenter
import dagger.internal.DaggerCollections

class MainActivity : AppCompatActivity(), MainPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar()
//        DaggerCoffeeComponent.create().make().brew()
//        val coffeeMaker = CoffeeMaker()
//        DaggerCoffeeComponent.create().inject(coffeeMaker)
//        coffeeMaker.brew()

    }
}
