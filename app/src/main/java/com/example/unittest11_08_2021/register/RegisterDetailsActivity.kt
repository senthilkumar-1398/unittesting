package com.example.unittest11_08_2021.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import com.example.unittest11_08_2021.R

class RegisterDetailsActivity : AppCompatActivity() {
    lateinit var etFirstName: AppCompatEditText
    lateinit var etLastName: AppCompatEditText
    lateinit var etMobileNo: AppCompatEditText
    lateinit var etEmailId: AppCompatEditText
    lateinit var etPassword: AppCompatEditText
    lateinit var etConfirmPassword: AppCompatEditText
    lateinit var cbTerms: AppCompatCheckBox
    lateinit var btnSubmit: AppCompatButton
    var registerFieldValidations: RegisterFieldValidations = RegisterFieldValidations()
    var mTerms: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_details)
        etFirstName = findViewById<AppCompatEditText>(R.id.et_firstname)
        etLastName = findViewById<AppCompatEditText>(R.id.et_lastname)
        etMobileNo = findViewById<AppCompatEditText>(R.id.et_mobile_no)
        etEmailId = findViewById<AppCompatEditText>(R.id.et_email)
        etPassword = findViewById<AppCompatEditText>(R.id.et_password)
        etConfirmPassword = findViewById<AppCompatEditText>(R.id.et_confirm_password)
        cbTerms = findViewById<AppCompatCheckBox>(R.id.cb_terms)
        btnSubmit = findViewById<AppCompatButton>(R.id.btn_submit)
        cbTerms.setOnCheckedChangeListener { buttonView, isChecked ->
            mTerms = isChecked
        }
        btnSubmit.setOnClickListener {
            if (validate()
            ) {
                Log.d("TAG", "onCreate: req")
                Toast.makeText(this, "Field Required", Toast.LENGTH_SHORT).show()
            } else {
                Log.d("TAG", "onCreate: ok")
                Toast.makeText(this, "Registered SuccessFull", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun validate(): Boolean {
        if (registerFieldValidations.validation(
                etFirstName.text.toString(),
                etLastName.text.toString(),
                etMobileNo.text.toString(),
                etEmailId.text.toString(),
                etPassword.text.toString(),
                etConfirmPassword.text.toString(),
                mTerms
            )
        ) {
            return false
        }
        return true
    }
}