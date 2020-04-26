package com.devmmurray.mvvm_architecture.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devmmurray.mvvm_architecture.data.api.ApiHelper
import com.devmmurray.mvvm_architecture.data.repository.MainRepo
import com.devmmurray.mvvm_architecture.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory{

    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
           return MainViewModel(MainRepo(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}