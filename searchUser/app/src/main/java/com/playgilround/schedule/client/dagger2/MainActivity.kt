package com.playgilround.schedule.client.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.fragment.app.FragmentManager
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
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val component = DaggerGithubUserListComponent.builder()
            .githubUserListModule(GithubUserListModule(this))
            .build()
        component.inject(this)

        fragmentManager.beginTransaction().add(R.id.main_container, userFragment, "1").commit()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

    fun searchGithubUser(searchWord: String) {
        if (searchWord.isBlank()) {
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
                query?.let {
                    searchGithubUser(query)
                }
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

    override fun onDataLoaded(storeResponse: SearchResponse) {
        userFragment.userAdapter.apply {
            items.clear()
            items.addAll(storeResponse.items)
            notifyDataSetChanged()
        }
    }

    override fun onDataFailed() {
        userFragment.userAdapter.apply {
            items.clear()
            notifyDataSetChanged()
        }
    }
}
