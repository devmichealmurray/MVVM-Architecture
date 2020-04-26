package com.devmmurray.mvvm_architecture.data.repository

import com.devmmurray.mvvm_architecture.data.api.ApiHelper
import com.devmmurray.mvvm_architecture.data.model.User
import io.reactivex.Single

class MainRepo(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }
}