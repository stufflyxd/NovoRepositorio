package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaConfig : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_config)

        val profileImage: ImageView = findViewById(R.id.profile_image)
        val editProfile: ImageView = findViewById(R.id.edit_profile)
        val personalInfo: TextView = findViewById(R.id.personal_info)
        val trainingData: TextView = findViewById(R.id.training_data)
        val preferences: TextView = findViewById(R.id.preferences)
        val support: TextView = findViewById(R.id.support)
        val logoutButton: TextView = findViewById(R.id.deslogar)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        personalInfo.setOnClickListener {
            // abrir tela de informaões pessoais
            val intent = Intent(this, TelaInformacoesPessoaisAluno::class.java)
            startActivity(intent)
        }

        trainingData.setOnClickListener {
            // tela dados de treino
            // val intent = Intent(this)
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
                    // val intent = Intent(this, )
                    true
                }

                else -> false
            }
        }
    }
}