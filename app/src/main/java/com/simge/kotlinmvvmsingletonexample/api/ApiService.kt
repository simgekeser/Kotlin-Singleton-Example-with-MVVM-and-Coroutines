package com.simge.kotlinmvvmsingletonexample.api

import com.simge.kotlinmvvmsingletonexample.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{
    @GET("placeholder/user/{userId}")
    suspend fun getUser(
        @Path("userId") userId : String
    ) : User
}