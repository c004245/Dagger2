package com.playgilround.schedule.client.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.playgilround.schedule.client.dagger2.presenter.MainPresenter
import dagger.internal.DaggerCollections
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        DaggerCoffeeComponent.create().make().brew()
//        val coffeeMaker = CoffeeMaker()
//        DaggerCoffeeComponent.create().inject(coffeeMaker)
//        coffeeMaker.brew()

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

        }
    }
}
