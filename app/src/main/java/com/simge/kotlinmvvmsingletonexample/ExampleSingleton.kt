package com.simge.kotlinmvvmsingletonexample

import com.simge.kotlinmvvmsingletonexample.model.User

object ExampleSingleton {
    val singletonUser: User by lazy {
        User("simgekeser@gmail.com", "simge", "image.png")
    }
}