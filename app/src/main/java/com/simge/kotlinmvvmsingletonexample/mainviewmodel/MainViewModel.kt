package com.simge.kotlinmvvmsingletonexample.mainviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.simge.kotlinmvvmsingletonexample.model.User
import com.simge.kotlinmvvmsingletonexample.repository.Repository

class MainViewModel : ViewModel(){
    private val _userId: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations
        .switchMap(_userId){userId->
            Repository.getUser(userId)
        }

    fun setUserId(userId: String){
        val update = userId
        if(_userId.value==update){
            return
        }
        _userId.value=update
    }

    fun cancelJobs(){
        Repository.cancelJob()
    }
}