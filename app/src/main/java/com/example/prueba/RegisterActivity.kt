package com.example.prueba

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val nameInput : EditText = findViewById(R.id.Name_input)
        val emailInput : EditText = findViewById(R.id.Email_input)
        val passwordInput : EditText = findViewById(R.id.Password_input)
        val repeatpasswordInput : EditText = findViewById(R.id.RepeatPassword_input)
        val buttonsignin: Button = findViewById(R.id.button_sign_up)
        val errorText: TextView = findViewById(R.id.Text_error)
        val buttonBack: ImageButton = findViewById(R.id.button_back)

        buttonsignin.setOnClickListener {

            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val repeatpassword = repeatpasswordInput.text.toString().trim()

            var isValid = true
            var errorMessage = ""

            if (name.isEmpty()) {
                errorMessage = "El nombre no puede estar vacío."
                isValid = false
            }

            if (email.isEmpty()) {
                errorMessage = "El e-mail no puede estar vacío."
                isValid = false
            }

            if (password.length < 6) {
                errorMessage = "La contraseña debe tener al menos 6 caracteres."
                isValid = false
            }

            if (password != repeatpassword) {
                errorMessage = "Las contraseñas no coinciden."
                isValid = false
            }

            if (isValid) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            } else {
                errorText.text = errorMessage
                errorText.visibility = android.view.View.VISIBLE
            }
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}