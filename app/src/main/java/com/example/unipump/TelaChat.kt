package com.example.unipump

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TelaChat : AppCompatActivity() {

    lateinit var setaVoltar: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_chat)

        setaVoltar = findViewById(R.id.SetaVoltar)
        configurarEventos()

    }

    fun configurarEventos() {

        // Definindo o clique do botão de voltar
        setaVoltar.setOnClickListener {
            onBackPressed() // Isso chama o comportamento de voltar para a tela anterior
        }
    }


    }