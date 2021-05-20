package com.example.singletonexamplewithcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel=ViewModelProvider(this).get(MainViewModel::class.java)

        viewmodel.user.observe(this, Observer {
            println("DEBUG: $it")
        })

        viewmodel.setUserId("1")

        println("DEBUG: ExampleSingleton: ${ExampleSingleton}")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewmodel.cancelJob()
    }
}