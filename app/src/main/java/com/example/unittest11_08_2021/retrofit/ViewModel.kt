package com.example.unittest11_08_2021.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    private var signinViewModelRepository: ViewModelRepository
    lateinit var loginLiveData: LiveData<Resource<ModelClass?>>

    init {
        signinViewModelRepository = ViewModelRepository()
    }

    fun login() {
        loginLiveData = signinViewModelRepository.registerPhone()
    }

    fun login2(): String? {
        return "loginLiveData.value?.message"
    }

}

