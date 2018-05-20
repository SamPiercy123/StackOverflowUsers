package com.example.sampiercy.stackoverflowusers.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sampiercy.stackoverflowusers.data.repository.UserDataRepository
import javax.inject.Inject

class StackOverflowViewModelFactory @Inject constructor(private val userDataRepository: UserDataRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StackOverflowViewModel(userDataRepository) as T
    }

}