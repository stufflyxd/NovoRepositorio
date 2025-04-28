package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaTreinoAluno : AppCompatActivity() {

   private lateinit var ficha_1: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_treino_aluno)

        // 1. Acessar o BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 2. Concteinar como botão
        ficha_1 = findViewById(R.id.container_ficha1)

        ficha_1.setOnClickListener {
            val intent = Intent(this, TelaFichaTreino::class.java)
            startActivity(intent)
        }


        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    val intent = Intent(this, TelaPrincipalAluno::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_treinos -> {
                    // Ir para a tela de treinos
                    true
                }
                R.id.nav_config -> {
                    val intent = Intent(this, TelaConfig:: class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_chat -> {
                    // val intent = Intent(this, )
                    true
                }
                else -> false
            }
        }
    }
}