package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView


class TelaConfiguracao_Funcionario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_configuracao_funcionario)
        val profileImage: ImageView = findViewById(R.id.profile_image)

        val personalInfo: TextView = findViewById(R.id.personal_info)
        val preferences: TextView = findViewById(R.id.preferences)
        val support: TextView = findViewById(R.id.support)
        val logoutButton: TextView = findViewById(R.id.deslogar)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        personalInfo.setOnClickListener {
            // abrir tela de informaões pessoais
            val intent = Intent(this, TelaInformacaoPessoal_funcionario::class.java)
            startActivity(intent)
        }


        preferences.setOnClickListener {
            // tela preferencias
            val intent = Intent(this, TelaPref::class.java)
            startActivity(intent)
        }

        support.setOnClickListener {
            // tela chat de suporte
            // val intent = Intent(this)
        }

        logoutButton.setOnClickListener {
            Toast.makeText(this, "Você foi deslogado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, TelaInicial::class.java)
            startActivity(intent)
            // adicionar lógica para voltar para a tela de login
        }


        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    // O que acontece quando o item "Início" é clicado
                    val intent = Intent(this, TelaFuncionario::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_chat -> {
                    // Abre a tela de chat
                    val intent = Intent(this, TelaChat::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_config -> {
                    // Abre a tela de configurações
                    true
                }

                else -> false
            }
        }


    }
}