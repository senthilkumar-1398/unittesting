package com.example.unittest11_08_2021.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.unittest11_08_2021.retrofit.webserrvice.APIClient
import com.example.unittest11_08_2021.retrofit.webserrvice.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelRepository {

    var loginLiveData = MutableLiveData<Resource<ModelClass?>>()
    val mApiInterface = APIClient.getClient()!!.create(APIInterface::class.java)

    fun registerPhone(): LiveData<Resource<ModelClass?>> {
//        loginLiveData.value = Resource.loading()
        val mCallLoginPojo: Call<ModelClass> = mApiInterface.getAllData()
        mCallLoginPojo.enqueue(object : Callback<ModelClass> {

            override fun onResponse(call: Call<ModelClass>, response: Response<ModelClass>) {
                if (response.code() == 200) {
                    val data = response.body()
                    loginLiveData.value = Resource.success(data)
                } else {
                    loginLiveData.value = Resource.error(response.message())
                }
            }

            override fun onFailure(call: Call<ModelClass>, t: Throwable) {
                loginLiveData.value = Resource.error(t.message.toString())
                Log.e("onFailure", "onFailure: " + t)
            }
        })

        return loginLiveData
    }
}