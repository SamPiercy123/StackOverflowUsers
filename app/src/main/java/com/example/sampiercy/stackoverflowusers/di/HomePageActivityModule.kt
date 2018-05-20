package com.example.sampiercy.stackoverflowusers.di

import com.example.sampiercy.stackoverflowusers.data.repository.UserDataRepository
import com.example.sampiercy.stackoverflowusers.viewmodels.StackOverflowViewModel
import dagger.Module
import dagger.Provides

@Module
class HomePageActivityModule {

    @Provides
    fun provideStackOverflowViewModel(userDataRepository: UserDataRepository) = StackOverflowViewModel(userDataRepository)

}