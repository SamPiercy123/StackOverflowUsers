package com.example.sampiercy.stackoverflowusers.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sampiercy.stackoverflowusers.R
import com.example.sampiercy.stackoverflowusers.data.model.User
import kotlinx.android.synthetic.main.activity_user_detail.*
import java.text.SimpleDateFormat
import java.util.*

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val USER_ITEM_EXTRA = "user_item_extra"

        fun start(context: Context, user: User) {
            val intent = Intent(context, UserDetailActivity::class.java)
            intent.putExtra(USER_ITEM_EXTRA, user)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        val user = intent.getParcelableExtra<User>(USER_ITEM_EXTRA)

        profilePic.setImageURI(user.profileImage)
        name.text = String.format(getString(R.string.name), user.displayName)
        identity.text = String.format(getString(R.string.identity), user.userId)
        reputation.text = String.format(getString(R.string.reputation), user.reputation)
        location.text = String.format(getString(R.string.location), user.location)
        val simpleDateFormat = SimpleDateFormat( getString(R.string.date_format), Locale.getDefault())
        creationDate.text = String.format(getString(R.string.creation_date), simpleDateFormat.format(Date(user.creationDate.toLong() * 1000)))
    }

}