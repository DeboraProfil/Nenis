package com.ilustris.nenis.ui.authentication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ilustris.nenis.R
import com.ilustris.nenis.databinding.ActivityHomeBinding
import com.ilustris.nenis.databinding.ActivityLoginBinding



class AuthenticationActivity: AppCompatActivity(R.layout.activity_login) {
var activityLoginBinding: ActivityLoginBinding? = null
    var isLogin = true
    val authenticationViewModel = AuthenticationViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityLoginBinding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(activityLoginBinding!!.root)
        activityLoginBinding?.setupView()
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.

    }

    private fun reload() {
        TODO("Not yet implemented")
    }

    fun ActivityLoginBinding.setupView(){
        sgnUp.setOnClickListener {
            isLogin = !isLogin
            updateView()
        }
        btnLogin.setOnClickListener{
            authenticationViewModel.authenticate(isLogin, edtEmail.text.toString(),edtPassword.text.toString(),edtUser.text.toString())
        }
    }

    fun ActivityLoginBinding.updateView(){
        if (isLogin){
            edtUser.visibility = View.GONE
        }else  {
        edtUser.visibility = View.VISIBLE}
    }
}

