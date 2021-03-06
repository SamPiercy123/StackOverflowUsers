package com.example.sampiercy.stackoverflowusers.di

import android.app.Application
import com.example.sampiercy.stackoverflowusers.StackOverflowApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AndroidSupportInjectionModule::class, AndroidInjectionModule::class,
            CoreModule::class, ActivityBuilder::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(stackOverflowApplication: StackOverflowApplication)

}