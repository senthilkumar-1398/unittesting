package com.example.unittest11_08_2021.uitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.datastore.preferences.preferencesKey
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.unittest11_08_2021.R
import com.example.unittest11_08_2021.datastoretest.DataStoreManager
import kotlinx.coroutines.launch

class UiTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_test)

        val btnChange: AppCompatButton = findViewById(R.id.btn_submit)

        val etName: AppCompatEditText = findViewById(R.id.edittext_name)
        val etEmail: AppCompatEditText = findViewById(R.id.edittext_mail)
        val etAddress: AppCompatEditText = findViewById(R.id.edittext_address)

        val tvName: AppCompatTextView = findViewById(R.id.tv_name)
        val tvEmail: AppCompatTextView = findViewById(R.id.tv_email)
        val tvAddress: AppCompatTextView = findViewById(R.id.tv_address)

        btnChange.setOnClickListener {
            tvName.text = etName.text.toString()
            tvEmail.text = etEmail.text.toString()
            tvAddress.text = etAddress.text.toString()
        }
    }
}