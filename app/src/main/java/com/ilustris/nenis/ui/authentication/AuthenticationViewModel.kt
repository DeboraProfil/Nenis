package com.ilustris.nenis.ui.authentication

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

class AuthenticationViewModel {
    private val auth = Firebase.auth

    fun authenticate(login: Boolean,email: String, password: String, username:String) {

        if (login){
            signIn(email, password)
        }
        else {
            signUp(email, password, username)
        }

    }
    fun signUp (email:String, password:String,username: String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                val changeRequest = userProfileChangeRequest {
                    displayName = username
                }
                auth.currentUser?.updateProfile(changeRequest)
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "User profile updated. New username = ${auth.currentUser?.displayName}")
                        }
                    }
                val user = auth.currentUser
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)

            }
        }
    }
    fun signIn (email:String, password:String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                val user = auth.currentUser
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)

            }
        }
    }
}
private const val TAG = "authentication"