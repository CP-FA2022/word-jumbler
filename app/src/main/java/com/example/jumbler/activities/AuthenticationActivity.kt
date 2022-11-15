package com.example.jumbler.activities

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.jumbler.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val editLoginEmail: EditText by lazy { findViewById(R.id.editLoginEmail) }
    private val editLoginPassword: EditText by lazy { findViewById(R.id.editLoginPassword) }
    private val btnLogin: Button by lazy { findViewById(R.id.btnLogin) }
    private val editRegisterEmail: EditText by lazy { findViewById(R.id.editRegisterEmail) }
    private val editRegisterPassword: EditText by lazy { findViewById(R.id.editRegisterPassword) }
    private val editRegisterConfirm: EditText by lazy { findViewById(R.id.editRegisterConfirm) }
    private val btnRegister: Button by lazy { findViewById(R.id.btnRegister) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        auth = Firebase.auth
        btnLogin.setOnClickListener {
            loginHandler()
        }
        btnRegister.setOnClickListener {
            registerHandler()
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun loginHandler() {
        val email = editLoginEmail.text
        val password = editLoginPassword.text

        if (password.length < 6) {
            Toast.makeText(this, "Your password has an invalid # of characters!", Toast.LENGTH_LONG).show()
        } else if (!(email.contains("@"))) {
            Toast.makeText(this, "Your email is invalid!", Toast.LENGTH_LONG).show()
        } else if ((email.isNullOrEmpty()) || (password.isNullOrBlank())) {
            Toast.makeText(this, "One or more fields are empty!", Toast.LENGTH_LONG).show()
        } else {
            signIn(email.toString(), password.toString())
        }
    }

    fun registerHandler() {
        val email = editRegisterEmail.text
        val password = editRegisterPassword.text
        val confirm = editRegisterConfirm.text

        if ((password.length < 6) || (confirm.length < 6)) {
            Toast.makeText(this, "Your password has an invalid # of characters!", Toast.LENGTH_LONG).show()
        } else if (!(email.contains("@"))) {
            Toast.makeText(this, "Your email is invalid!", Toast.LENGTH_LONG).show()
        } else if ((email.isNullOrEmpty()) || (password.isNullOrBlank())) {
            Toast.makeText(this, "One or more fields are empty!", Toast.LENGTH_LONG).show()
        }  else if (password.toString() != confirm.toString()) {
            Toast.makeText(this ,"Make sure your password fields are matching!", Toast.LENGTH_SHORT).show()
        } else {
            createAccount(email.toString(), password.toString())
        }
    }

}