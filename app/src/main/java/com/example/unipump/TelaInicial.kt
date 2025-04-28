package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaInicial : AppCompatActivity() {

    private lateinit var btnAluno: Button
    private lateinit var btnFuncionario: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CicloDeVida", "onCreate chamado")
        setContentView(R.layout.activity_tela_inicial)

        // Inicializa os componentes da UI
        btnAluno = findViewById(R.id.btnAluno)
        btnFuncionario = findViewById(R.id.btnFuncionario)

        // Configura os eventos
        configurarEventos()
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

    private fun configurarEventos() {
        btnAluno.setOnClickListener {
            val intent = Intent(this, TelaLogin::class.java)
            intent.putExtra("tipo", "aluno")
            startActivity(intent)
        }
        btnFuncionario.setOnClickListener {
            val intent = Intent(this, TelaLogin::class.java)
            intent.putExtra("tipo", "funcionario")
            startActivity(intent)
        }
    }
}
