package com.testing.testing

interface MainActivityView {
    fun getEmail() :String
    fun getPassword() :String

    fun setEmptyEmailError()
    fun setInvalidEmailError()

    fun setEmptyPasswordError()
    fun setInvalidPasswordError()
    fun successLogin()
}