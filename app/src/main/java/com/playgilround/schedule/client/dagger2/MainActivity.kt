package com.playgilround.schedule.client.dagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.internal.DaggerCollections

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerCoffeeComponent.create().make().brew()
//        val coffeeMaker = CoffeeMaker()
//        DaggerCoffeeComponent.create().inject(coffeeMaker)
//        coffeeMaker.brew()

    }
}
