package com.example.sampiercy.stackoverflowusers.viewmodels

import android.arch.lifecycle.ViewModel
import com.example.sampiercy.stackoverflowusers.data.model.UsersResponse
import com.example.sampiercy.stackoverflowusers.data.repository.UserDataRepository
import io.reactivex.Single
import javax.inject.Inject

class StackOverflowViewModel @Inject constructor(private val userDataRepository: UserDataRepository) : ViewModel() {

    private var usersResponse: UsersResponse? = null

    open fun getTopTwentyUsers(refresh: Boolean): Single<UsersResponse> {
        if(!refresh) usersResponse?.let { return Single.just(usersResponse) }
        return userDataRepository.getUsers().flatMap {
            usersResponse = it
            Single.just(it)
        }
    }
}