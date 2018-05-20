package com.example.sampiercy.stackoverflowusers

import android.app.Activity
import android.app.Application
import com.example.sampiercy.stackoverflowusers.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class StackOverflowApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        initialiseDaggerComponent()
    }

    open fun initialiseDaggerComponent() = DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    override fun activityInjector(): AndroidInjector<Activity>
            = activityDispatchingAndroidInjector
}