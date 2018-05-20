package com.example.sampiercy.stackoverflowusers.api

import com.example.sampiercy.stackoverflowusers.data.model.UsersResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface StackOverflowApiService {

    companion object {
        const val SITE_QUERY = "site=stackoverflow"
    }

    @GET("2.2/users?$SITE_QUERY")
    fun findUsers(@Query("order") order: String, @Query("sort") sortBy: String,
                  @Query("pagesize") numberUsers: Int): Single<UsersResponse>

}