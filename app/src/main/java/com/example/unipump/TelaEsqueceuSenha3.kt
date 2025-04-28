package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaEsqueceuSenha3 : AppCompatActivity() {

    private lateinit var btnValidar : Button
    private lateinit var textInstruction : TextView
    private lateinit var textReenviarCodigo : TextView
    private lateinit var edtCodigo1 : EditText
    private lateinit var edtCodigo2 : EditText
    private lateinit var edtCodigo3 : EditText
    private lateinit var edtCodigo4 : EditText
    private lateinit var edtCodigo5 : EditText
    private var codigoEnviado: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_esqueceu_senha3)

        btnValidar = findViewById(R.id.btnValidar)
        textInstruction = findViewById(R.id.textViewInstruction3)
        textReenviarCodigo = findViewById(R.id.tvReenviarCodigo)
        edtCodigo1 = findViewById(R.id.edit_text1_3)
        edtCodigo2 = findViewById(R.id.edit_text2_3)
        edtCodigo3 = findViewById(R.id.edit_text3_3)
        edtCodigo4 = findViewById(R.id.edit_text4_3)
        edtCodigo5 = findViewById(R.id.edit_text5_3)

        codigoEnviado = intent.getStringExtra("codigoEnviado")


        val tipo = intent.getStringExtra("tipo") ?: ""
        textInstruction.text = when {
            isValidEmail(tipo) -> "Insira no campo abaixo o código de verificação de 5 digitos enviado para o seu $tipo"
            isValidPhone(tipo) -> "Insira no campo abaixo o código de verificação de 5 digitos enviado para o seu $tipo"
            else -> "Tipo inválido"
        }

        configurarEventos()

    }

    private fun configurarEventos() {
        btnValidar.setOnClickListener {
            validarCodigo()
        }

        textReenviarCodigo.setOnClickListener{
            reenviarCodigo()
        }

    }

    // Função para validar o código
    private fun validarCodigo() {
        val codigoInserido = edtCodigo1.text.toString() +
                edtCodigo2.text.toString() +
                edtCodigo3.text.toString() +
                edtCodigo4.text.toString() +
                edtCodigo5.text.toString()


        if (codigoInserido == codigoEnviado) {
            // Código correto, redireciona para a próxima tela
            val intent = Intent(this, TelaEsqueceuSenha4::class.java)
            startActivity(intent)
            finish() // Finaliza a atividade atual
        } else {
            // Código incorreto, exibe uma mensagem de erro
            Toast.makeText(this, "Código incorreto. Tente novamente.", Toast.LENGTH_SHORT).show()
        }
    }

    // Função para reenviar o código (Simulação)
    private fun reenviarCodigo() {

        Toast.makeText(this, "Código reenviado!", Toast.LENGTH_SHORT).show()

        codigoEnviado = "54321"
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