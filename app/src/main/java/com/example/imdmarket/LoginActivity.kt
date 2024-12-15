package com.example.imdmarket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Conectando o layout XML ao código Kotlin

        // Ligação dos componentes do layout
        val username = findViewById<EditText>(R.id.editTextUsuario)  // Alterado para 'editTextUsuario'
        val password = findViewById<EditText>(R.id.editTextSenha)  // Alterado para 'editTextSenha'
        val loginButton = findViewById<Button>(R.id.buttonLogin)

        // Ação para o botão de login
        loginButton.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()

            // Validação simples de login
            if (user == "admin" && pass == "1234") {
                Toast.makeText(this, "Bem-vindo, $user!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
