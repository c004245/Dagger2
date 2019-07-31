package com.playgilround.schedule.client.dagger2.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.playgilround.schedule.client.dagger2.R
import com.playgilround.schedule.client.dagger2.model.User
import kotlinx.android.synthetic.main.list_item.view.*

class UserListAdapter(var context: Context?, val items: ArrayList<User>) : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.run {
            bindView(items[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): UserListViewHolder {
        return UserListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = items.size


    inner class UserListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(userListItem: User) {
            with(view) {
                user_name.text = userListItem.login
                user_repo_url.text = userListItem.repos_url

                Glide.with(context)
                    .load(userListItem.avatar_url)
                    .into(user_image)
                user_info_layout.setOnClickListener {

                }
            }
        }
    }
}