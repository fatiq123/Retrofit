package com.example.retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.model.User
import com.example.retrofit.repository.MainRepository

class MainViewModel: ViewModel() {

    private val repository: MainRepository = MainRepository()

    private val userLiveData: MutableLiveData<List<User>> = MutableLiveData()


    private suspend fun getUserResponse() {
        val user = repository.getUserApi()
        userLiveData.postValue(user)
    }



    fun getUserFromLiveData(): LiveData<List<User>> {
        return userLiveData
    }
}