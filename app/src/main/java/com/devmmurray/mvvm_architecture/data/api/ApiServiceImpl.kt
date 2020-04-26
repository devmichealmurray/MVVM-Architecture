package com.devmmurray.mvvm_architecture.data.api

import com.devmmurray.mvvm_architecture.data.model.User
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/users"

class ApiServiceImpl: ApiService {

    override fun getUsers(): Single<List<User>> {
        return Rx2AndroidNetworking.get(BASE_URL)
            .build()
            .getObjectListSingle(User::class.java)
    }
}