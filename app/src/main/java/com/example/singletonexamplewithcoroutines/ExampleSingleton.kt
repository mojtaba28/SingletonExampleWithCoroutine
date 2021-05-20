package com.example.singletonexamplewithcoroutines

import com.example.singletonexamplewithcoroutines.model.User

object ExampleSingleton {

    val singletonUser: User by lazy {
        User("mojtaba.joshaghani99@gmail.com", "mojtaba", "some_image_url.png")
    }
}