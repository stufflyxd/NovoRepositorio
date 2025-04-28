package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaEsqueceuSenha2 : AppCompatActivity() {

    private lateinit var btnEditar : Button
    private lateinit var btnConfirmar : Button
    private lateinit var textInstruction : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_esqueceu_senha2)
        Log.d("CicloDeVida", "onStart chamado")

        btnEditar = findViewById(R.id.btnEditar)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        textInstruction = findViewById(R.id.textViewInstruction)

        configurarEventos()

        val tipo = intent.getStringExtra("tipo") ?: ""
        textInstruction.text = when {
            isValidEmail(tipo) -> "Antes de enviarmos o código, $tipo é o E-mail correto?"
            isValidPhone(tipo) -> "Antes de enviarmos o código, $tipo é o seu número correto?"
            else -> "Tipo inválido"
        }
    }



    private fun configurarEventos() {
        btnEditar.setOnClickListener {
            val intent = Intent(this, TelaEsqueceuSenha::class.java)
            startActivity(intent)
        }

        btnConfirmar.setOnClickListener {
            val intent = Intent(this, TelaEsqueceuSenha3::class.java)
            val tipo = intent.getStringExtra("tipo")
            intent.putExtra("tipo", tipo)
            intent.putExtra("codigoEnviado", "12345")
            startActivity(intent)
        }
    }




    override fun onStart() {
        super.onStart()
        Log.d("CicloDeVida", "onStart chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "onResume chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "onPause chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CicloDeVida", "onStop chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CicloDeVida", "onDestroy chamado")
    }




    // Função para validar o e-mail
    private fun isValidEmail(email: String): Boolean {
        // Regex para validar e-mails simples
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        return email.matches(emailPattern.toRegex())
    }

    // Função para validar o número de telefone
    private fun isValidPhone(phone: String): Boolean {
        // Regex para validar números de telefone (aqui estou considerando números com 10 ou 11 dígitos)
        val phonePattern = "^\\+?[0-9]{10,13}$"
        return phone.matches(phonePattern.toRegex())
    }
}