package com.playgilround.schedule.client.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val searchView = menu?.findItem(R.id.search_bar)?.actionView as? SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(s: String?): Boolean {
                s?.let {
                    searchGithubUser(s)
                }
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

        }
    }
}
