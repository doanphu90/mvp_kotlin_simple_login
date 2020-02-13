package com.kotlin.democoroutines.presenter

import com.kotlin.democoroutines.R
import com.kotlin.democoroutines.View.ILoginView
import com.kotlin.democoroutines.model.User

class LoginPresenter(internal val iLoginView: ILoginView) : ILoginPresenter {
    override fun onLogin(email: String, pass: String) {
        val user = User(email, pass)
        val resulcode = user.isDataValid()
        when (resulcode){
            0 -> iLoginView.onLoginResult((R.string.emailnull))
            1 -> iLoginView.onLoginResult((R.string.email_invalid))
            2 -> iLoginView.onLoginResult((R.string.passnull))
            else -> iLoginView.onLoginResult(R.string.loginsuccess)
        }
    }

}