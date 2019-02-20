package com.testing.testing

interface MainActivityPresenter {
    fun doLogin()
    fun validateEmail(email :String?):Boolean
    fun validatePassword(password: String?):Boolean
}