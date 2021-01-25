package com.simge.kotlinmvvmsingletonexample.repository

import androidx.lifecycle.LiveData
import com.simge.kotlinmvvmsingletonexample.api.MyRetrofitBuilder
import com.simge.kotlinmvvmsingletonexample.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {

    var job: CompletableJob?=null

    fun getUser(userId:String): LiveData<User>{
        job= Job()
        return object: LiveData<User>(){
            override fun onActive() {
                job?.let {theJob->
                    CoroutineScope(IO + theJob).launch {
                        val user = MyRetrofitBuilder.apiService.getUser(userId)
                        withContext(Main){
                            value=user
                            theJob.complete()

                        }
                    }
                }
            }
        }
    }

    fun cancelJob(){
        job?.cancel()
    }
}