package com.testing.testing

class MainActivityPresenterImplementation(var mainActivityView: MainActivityView) : MainActivityPresenter{

    override fun doLogin() {
        if (
            validateEmail(mainActivityView.getEmail())
            && validatePassword(mainActivityView.getPassword())){
           mainActivityView.successLogin()
        }
    }

    override fun validateEmail(email:String?): Boolean {
        return if (email.isNullOrEmpty()){
            mainActivityView.setEmptyEmailError()
            false
        }else if (!email.contains("@")){
            mainActivityView.setInvalidEmailError()
            false
        }else {
            true
        }
    }


    override fun validatePassword(password:String?): Boolean {
        return when {
            password.isNullOrEmpty() -> {
                mainActivityView.setEmptyPasswordError()
                false
            }
            password.length < 6 -> {
                mainActivityView.setInvalidPasswordError()
                false
            }
            else -> {
                true
            }
        }
    }
}