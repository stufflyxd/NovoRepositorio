package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaFichaTreino : AppCompatActivity() {

    private lateinit var bntComecar: Button
    private lateinit var btnVoltar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tela_ficha_treino)

        bntComecar = findViewById(R.id.buttonStart)
        btnVoltar = findViewById(R.id.btn_back)

        configurarEvento()


        // 1. Acessar o BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    // Já está na tela de Início, talvez não precise fazer nada
                    true
                }

                R.id.nav_treinos -> {
                    // Ir para a tela de treinos
                    val intent = Intent(this, TelaTreinoAluno::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_config -> {
                    val intent = Intent(this, TelaConfig::class.java)
                    startActivity(intent)
                    true

                }

                R.id.nav_chat -> {
                    val intent = Intent(this,TelaChat::class.java)
                    startActivity(intent)
                    true
                }

                else -> {
                    false
                }
            }
        }
    }



    private fun configurarEvento(){

        bntComecar.setOnClickListener {
            val intent = Intent(this, TelaExercicioFinalizado:: class.java)
            startActivity(intent)
        }

        btnVoltar.setOnClickListener {
            finish()
        }


    }

}