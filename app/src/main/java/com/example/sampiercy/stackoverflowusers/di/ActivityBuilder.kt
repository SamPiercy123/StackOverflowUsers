package com.example.sampiercy.stackoverflowusers.di

import com.example.sampiercy.stackoverflowusers.ui.HomePageActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [HomePageActivityModule::class])
    abstract fun bindHomePageActivity(): HomePageActivity

}