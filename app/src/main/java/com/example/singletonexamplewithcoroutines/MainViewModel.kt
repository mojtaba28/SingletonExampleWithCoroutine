package com.example.singletonexamplewithcoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.singletonexamplewithcoroutines.model.User
import com.example.singletonexamplewithcoroutines.repository.Repository

class MainViewModel : ViewModel() {

    private val _userId: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations
            .switchMap(_userId){
                Repository.getUser(it)
            }

    fun setUserId(userId:String){
        val update=userId
        if (_userId.value==update){
            return
        }
        _userId.value=update

    }

    fun cancelJob(){
        Repository.cancelJob()
    }

}