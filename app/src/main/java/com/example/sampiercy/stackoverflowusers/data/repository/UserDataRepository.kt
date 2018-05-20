package com.example.sampiercy.stackoverflowusers.data.repository

import com.example.sampiercy.stackoverflowusers.api.StackOverflowApiService
import com.example.sampiercy.stackoverflowusers.data.model.UsersResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
open class UserDataRepository @Inject constructor(private val stackOverflowApiService: StackOverflowApiService) {

    open fun getUsers(): Single<UsersResponse> =
            stackOverflowApiService.findUsers("desc", "reputation", 20)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}