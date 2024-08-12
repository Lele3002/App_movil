package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    val VALID_USERNAME: String = "Juan Torres"
    val VALID_PASSWORD: String = "1234utn"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailInput : EditText = findViewById(R.id.Email_input)
        val passwordInput : EditText = findViewById(R.id.Password_input)
        val loginButton: Button = findViewById(R.id.button_login)
        val signinButton: Button = findViewById(R.id.button_sign_in)
        val errorText: TextView = findViewById(R.id.Text_error)


        loginButton.setOnClickListener {
            val username = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username == VALID_USERNAME && password == VALID_PASSWORD){
                val intent = Intent(applicationContext, WelcomeActivity::class.java)
                startActivity(intent)
            }
            else{
                errorText.text = "Datos incorrectos. Intente nuevamente"
                errorText.visibility = android.view.View.VISIBLE
            }
        }

        signinButton.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}