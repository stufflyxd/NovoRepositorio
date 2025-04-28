package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TelaEsqueceuSenha4 : AppCompatActivity() {

    private lateinit var edtNovaSenha: EditText
    private lateinit var edtConfirmaSenha: EditText
    private lateinit var btnConfirmar: Button

    // Variável simulando a senha salva
    private var senhaSalva: String = "12345" // A senha inicial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_esqueceu_senha4)

        // Inicializa os componentes da UI
        edtNovaSenha = findViewById(R.id.edtNova_senha)
        edtConfirmaSenha = findViewById(R.id.edConfirmarSenha4)
        btnConfirmar = findViewById(R.id.btnConfirmar4)

        configurarEventos()
    }

    private fun configurarEventos() {
        btnConfirmar.setOnClickListener {
            val novaSenha = edtNovaSenha.text.toString()
            val confirmaSenha = edtConfirmaSenha.text.toString()

            if (novaSenha == confirmaSenha) {
                // Atualiza a senha salva
                senhaSalva = novaSenha

                // Exibe mensagem de sucesso
                Toast.makeText(this, "Senha atualizada com sucesso!", Toast.LENGTH_SHORT).show()

                // Redireciona para a tela de login
                val intent = Intent(this, TelaLogin::class.java)
                intent.putExtra("novaSenha", novaSenha)  // Passa a nova senha para a tela de login
                startActivity(intent)
                finish() // Finaliza a tela atual
            } else {
                // Exibe erro se as senhas não coincidirem
                Toast.makeText(this, "As senhas não coincidem. Tente novamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
