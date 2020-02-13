package com.kotlin.democoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.UiThread
import com.kotlin.democoroutines.View.ILoginView
import com.kotlin.democoroutines.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity(), ILoginView {
    lateinit var presenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter(this)

        btn_login.setOnClickListener {
            presenter.onLogin(et_userName.text.toString(), et_passWord.text.toString())
        }
    }

    override fun onLoginResult(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
