package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaInformacoesPessoaisAluno : AppCompatActivity() {

    private lateinit var btn_voltar: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tela_informacoes_pessoais_aluno)
        btn_voltar = findViewById(R.id.btn_back)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    val intent = Intent(this, TelaPrincipalAluno::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_treinos -> {
                    val intent = Intent(this, TelaTreinoAluno::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_config -> {
                    true
                }

                R.id.nav_chat -> {
                    val intent = Intent(this,TelaChat::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }

    }

    override fun onStart() {

        // Voltar
        btn_voltar.setOnClickListener{
            val itent = Intent(this, TelaConfig:: class.java)
            startActivity(itent) //Tela de configurações
        }


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
}