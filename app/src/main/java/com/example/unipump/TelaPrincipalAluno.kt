package com.example.unipump

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaPrincipalAluno : AppCompatActivity() {

    private lateinit var visualizar: Button
    private lateinit var linkRelatorio: TextView
    private lateinit var notificacao: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal_aluno)

        // 1. Acessar o BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)



        // 2. Visualizar
        visualizar = findViewById(R.id.btn_visualizar)
        onClickVisualizar()
        // 3. Relatorio
        linkRelatorio = findViewById(R.id.link_relatorio)
        onClickRelatorio()

        // Notificação
        notificacao = findViewById(R.id.btn_notificacao)
        onClickNotificao()


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




    private fun onClickVisualizar() {
        visualizar.setOnClickListener {
            val intent = Intent(this, TelaFichaTreino::class.java)
            startActivity(intent)
        }
    }

    private fun onClickRelatorio(){
        linkRelatorio.setOnClickListener {
            val intent = Intent(this, TelaRelatorioSemanal::class.java)
            startActivity(intent)
        }
    }

    private fun onClickNotificao(){
        notificacao.setOnClickListener {
            val intent = Intent(this, TelaNotificacao_funcionario::class.java)
            startActivity(intent)
        }
    }
}



