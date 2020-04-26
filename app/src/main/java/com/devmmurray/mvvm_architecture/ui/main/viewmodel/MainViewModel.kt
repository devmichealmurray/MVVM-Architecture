package com.devmmurray.mvvm_architecture.ui.main.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.devmmurray.mvvm_architecture.data.model.User
import com.devmmurray.mvvm_architecture.data.repository.MainRepo
import com.devmmurray.mvvm_architecture.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepo: MainRepo): ViewModel() {

    private val users = MutableLiveData<com.devmmurray.mvvm_architecture.utils.Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    fun fetchUsers() {
        users.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepo.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    users.postValue(Resource.success(userList))
                }, { throwable ->
                    users.postValue(Resource.error("Error", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return users
    }
}

