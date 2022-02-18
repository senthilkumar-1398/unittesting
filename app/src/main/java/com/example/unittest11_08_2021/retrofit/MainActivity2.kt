package com.example.unittest11_08_2021.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.unittest11_08_2021.R

class MainActivity2 : AppCompatActivity() {
    private val mViewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createData()
    }

    private fun createData() {
        mViewModel.login()
    }
}