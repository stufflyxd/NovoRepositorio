package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaDadosDeTreino : AppCompatActivity() {

    private lateinit var linkRelatorio: TextView
    private lateinit var btnVoltar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_dados_de_treino)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        linkRelatorio = findViewById(R.id.historicoRelatorio)
        btnVoltar = findViewById(R.id.btnVoltar)

        configurarEventos()


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

    private fun configurarEventos(){
        linkRelatorio.setOnClickListener {
            val intent = Intent(this, TelaRelatorioSemanal::class.java)
            startActivity(intent)
        }

        btnVoltar.setOnClickListener {
            finish()
        }

    }
}