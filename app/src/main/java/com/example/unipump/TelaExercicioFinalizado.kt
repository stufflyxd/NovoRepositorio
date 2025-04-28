package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaExercicioFinalizado : AppCompatActivity() {

    private lateinit var finalizar: Button
    private lateinit var exercicio1: LinearLayout
    private lateinit var exercicio2: LinearLayout
    private lateinit var voltar: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_exercicio_finalizado)

        // Variáveis
        finalizar = findViewById(R.id.btnFinalizar)
        exercicio1 = findViewById(R.id.container_exercio1)
        exercicio2 = findViewById(R.id.container_exercio2)
        voltar = findViewById(R.id.btnVoltar)
        configEventos()
    }


    private fun configEventos(){

        finalizar.setOnClickListener {
            val intent = Intent(this, TelaPrincipalAluno:: class.java)
            startActivity(intent)
        }

        exercicio1.setOnClickListener {
            val intent = Intent(this, TelaExercicio1:: class.java)
            startActivity(intent)

        }

        exercicio2.setOnClickListener {
            val intent = Intent(this, TelaExercicio2:: class.java)
            startActivity(intent)
        }

        voltar.setOnClickListener{
            finish()
        }



    }

}