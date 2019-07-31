package com.playgilround.schedule.client.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.playgilround.schedule.client.dagger2.di.DaggerGithubUserListComponent
import com.playgilround.schedule.client.dagger2.di.GithubUserListModule
import com.playgilround.schedule.client.dagger2.model.SearchResponse
import com.playgilround.schedule.client.dagger2.presenter.MainContract
import com.playgilround.schedule.client.dagger2.presenter.MainPresenter
import com.playgilround.schedule.client.dagger2.view.UserFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var mPresenter: MainContract.Presenter

    private val userFragment: UserFragment = UserFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val component = DaggerGithubUserListComponent.builder()
            .githubUserListModule(GithubUserListModule(this))
            .build()
        component.inject(this)
        
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        DaggerCoffeeComponent.create().make().brew()
//        val coffeeMaker = CoffeeMaker()
//        DaggerCoffeeComponent.create().inject(coffeeMaker)
//        coffeeMaker.brew()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

    fun searchGithubUser(searchWord: String) {
        if (searchWord.isNullOrBlank()) {
            userFragment.userAdapter.apply {
                items.clear()
                notifyDataSetChanged()
            }
        } else {
            mPresenter.getGithubUserList(searchWord)
        }
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

    override fun onDataLoaded(storeResponse: SearchResponse) {
        Log.d(TAG, "onDataLoaded....")
        userFragment.userAdapter.apply {
            items.clear()
            items.addAll(storeResponse.items)
            notifyDataSetChanged()
        }
    }

    override fun onDataFailed() {
        Log.d(TAG, "onDataFailed")
        userFragment.userAdapter.apply {
            items.clear()
            notifyDataSetChanged()
        }
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}
