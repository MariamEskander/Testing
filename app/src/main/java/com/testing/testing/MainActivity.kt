package com.testing.testing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MainActivityView{
    override fun successLogin() {
        Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
    }

    override fun setEmptyEmailError() {
        email_et.error = getString(R.string.empty_email)
    }

    override fun setInvalidEmailError() {
        email_et.error = getString(R.string.invalid_email)
    }


    override fun setEmptyPasswordError() {
        password_et.error = getString(R.string.empty_password)
    }

    override fun setInvalidPasswordError() {
        password_et.error = getString(R.string.invalid_password)
    }


    override fun getPassword(): String {
        return password_et.text.trim().toString()
    }

    override fun getEmail(): String {
        return email_et.text.trim().toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenterImplementation = MainActivityPresenterImplementation(this)

        login_btn.setOnClickListener {
            presenterImplementation.doLogin()
        }
    }
}
