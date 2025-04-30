package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaNotificacao_funcionario : AppCompatActivity() {

    private lateinit var btnSetaVoltar : ImageButton
    private lateinit var btnNavegacao: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_notificacao_funcionario)

        btnSetaVoltar = findViewById(R.id.SetaVoltar)

        val btnNavegacao = findViewById<BottomNavigationView>(R.id.bottom_navigation)



        // Definindo o clique do botão de voltar
        btnSetaVoltar.setOnClickListener {
            finish() // Isso chama o comportamento de voltar para a tela anterior
        }

        btnNavegacao.setOnItemSelectedListener { item ->
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
                    val intent = Intent(this, TelaConfiguracao_Funcionario::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }

    }
}