package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class TelaLogin : AppCompatActivity() {

    private lateinit var btnVoltar: Button
    private lateinit var textEsqueceuSenha: TextView
    private lateinit var edtEmail: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnEntrar: AppCompatButton

    // Variável simulando a senha salva
    private var senhaSalva: String = "12345" // Senha inicial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        // Inicializa os componentes da UI
        btnVoltar = findViewById(R.id.btnVoltar)
        textEsqueceuSenha = findViewById(R.id.tvEsqueceuSenha)
        edtEmail = findViewById(R.id.etEmail)
        edtSenha = findViewById(R.id.etSenha)
        btnEntrar = findViewById(R.id.btnEntrar)

        // Configura os eventos
        configurarEventos()

        // Verifica se há uma nova senha passada pela Intent
        val novaSenha = intent.getStringExtra("novaSenha")
        if (novaSenha != null) {
            senhaSalva = novaSenha // Atualiza a senha salva com a nova senha
        }
    }

    private fun configurarEventos() {
        btnVoltar.setOnClickListener {
            val intent = Intent(this, TelaInicial::class.java)
            startActivity(intent)
        }

        textEsqueceuSenha.setOnClickListener {
            val intent = Intent(this, TelaEsqueceuSenha::class.java)
            startActivity(intent)
        }

        // Evento do botão de login
        btnEntrar.setOnClickListener {
            onEntrarClick()
        }
    }

    // Função de login
    private fun onEntrarClick() {
        val usuario = edtEmail.text.toString()
        val senha = edtSenha.text.toString()

        val tipo = intent.getStringExtra("tipo")

        if (tipo == "aluno") {
            // Para alunos: valida se o e-mail ou telefone é válido
            if (isValidEmail(usuario) || isValidPhone(usuario)) {
                // Aqui você deve comparar o e-mail com o que está salvo
                if (usuario == "aluno@exemplo.com" && senha == senhaSalva) {
                    val intent = Intent(this, TelaPrincipalAluno::class.java)
                    startActivity(intent)
                    finish() // Finaliza a tela de login
                } else {
                    Toast.makeText(this, "Usuário ou senha inválidos.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Caso o e-mail/telefone seja inválido
                Toast.makeText(this, "E-mail ou telefone inválido.", Toast.LENGTH_SHORT).show()
            }
        } else if (tipo == "funcionario") {
            if (isValidId(usuario)){
                if (usuario == "2413103" && senha == senhaSalva) {
                    // Verifique se o ID e a senha do funcionário estão corretos
                    val intent = Intent(this, TelaFuncionario::class.java)
                    startActivity(intent)
                    finish() // Finaliza a tela de login
                } else {
                    Toast.makeText(this, "ID ou senha inválidos.", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Tipo de usuário desconhecido.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        // Regex para validar e-mails simples
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        return email.matches(emailPattern.toRegex())
    }

    private fun isValidId(id: String): Boolean {
        val idPattern = "^[0-9]+$"  // Regex para validar apenas números
        return id.matches(idPattern.toRegex())
    }

    private fun isValidPhone(phone: String): Boolean {
        // Regex para validar números de telefone (aqui estou considerando números com 10 ou 11 dígitos)
        val phonePattern = "^\\+?[0-9]{10,13}$"
        return phone.matches(phonePattern.toRegex())
    }
}
