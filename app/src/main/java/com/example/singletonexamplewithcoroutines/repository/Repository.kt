package com.example.singletonexamplewithcoroutines.repository

import androidx.lifecycle.LiveData
import com.example.singletonexamplewithcoroutines.api.ApiClient
import com.example.singletonexamplewithcoroutines.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {

    var job: CompletableJob?=null

    fun getUser(userId:String): LiveData<User>{

        job= Job();

        return object:LiveData<User>(){

            override fun onActive() {
                super.onActive()
                job?.let { theJob->
                    CoroutineScope(IO+theJob).launch {
                        val user=ApiClient.apiService.getUser(userId)
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