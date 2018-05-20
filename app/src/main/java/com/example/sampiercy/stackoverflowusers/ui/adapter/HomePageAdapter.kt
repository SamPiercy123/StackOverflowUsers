package com.example.sampiercy.stackoverflowusers.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sampiercy.stackoverflowusers.R
import com.example.sampiercy.stackoverflowusers.data.model.UsersResponse
import com.example.sampiercy.stackoverflowusers.ui.UserDetailActivity
import com.example.sampiercy.stackoverflowusers.ui.viewholder.HomePageViewHolder
import kotlinx.android.synthetic.main.item_user_simple.view.*

class HomePageAdapter(var usersResponse: UsersResponse, val context: Context) : RecyclerView.Adapter<HomePageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_user_simple, parent, false)
        return HomePageViewHolder(itemView)
    }

    override fun getItemCount(): Int = usersResponse.items.size

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        val user = usersResponse.items[position]
        with(holder.itemView) {
            profilePic.setImageURI(user.profileImage)
            name.text = String.format(context.getString(R.string.name), user.displayName)
            reputation.text = String.format(context.getString(R.string.reputation), user.reputation)
            setOnClickListener({ UserDetailActivity.start(context, user) })
        }
    }

    open fun updateUserResponse(usersResponse: UsersResponse){
        this.usersResponse = usersResponse
        notifyDataSetChanged()
    }
}