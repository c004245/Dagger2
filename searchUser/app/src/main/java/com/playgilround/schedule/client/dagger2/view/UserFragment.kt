package com.playgilround.schedule.client.dagger2.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.playgilround.schedule.client.dagger2.R
import com.playgilround.schedule.client.dagger2.model.User
import com.playgilround.schedule.client.dagger2.view.adapter.UserListAdapter

class UserFragment : Fragment() {

    private val items by lazy { ArrayList<User>() }

    val userAdapter by lazy { UserListAdapter(context, items) }

    @SuppressLint("WrongConstant")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false) as RecyclerView
        view.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = userAdapter
        }
        return view
    }
}