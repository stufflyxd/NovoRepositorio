package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaFuncionario : AppCompatActivity() {

    /*private lateinit var gridLayout: GridLayout*/


    private lateinit var btnNavegacao : BottomNavigationView
    private lateinit var btnNotificacao : ImageButton
    private lateinit var usuario1 : LinearLayout
    private lateinit var usuario2 : LinearLayout
    private lateinit var usuario3 : LinearLayout
    private lateinit var usuario4 : LinearLayout
    private lateinit var usuario5 : LinearLayout
    private lateinit var usuario6: LinearLayout
    private lateinit var usuario7 : LinearLayout
    private lateinit var usuario8 : LinearLayout
    private lateinit var usuario9 : LinearLayout
    private lateinit var usuario10 : LinearLayout
    private lateinit var usuario11 : LinearLayout
    private lateinit var usuario12 : LinearLayout



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_funcionario)



        usuario1 = findViewById(R.id.usuario1)
        usuario2 = findViewById(R.id.usuario2)
        usuario3 = findViewById(R.id.usuario3)
        usuario4 = findViewById(R.id.usuario4)
        usuario5 = findViewById(R.id.usuario5)
        usuario6 = findViewById(R.id.usuario6)
        usuario7 = findViewById(R.id.usuario7)
        usuario8 = findViewById(R.id.usuario8)
        usuario9 = findViewById(R.id.usuario9)
        usuario10 = findViewById(R.id.usuario10)
        usuario11 = findViewById(R.id.usuario11)
        usuario12 = findViewById(R.id.usuario12)

        btnNavegacao = findViewById(R.id.bottom_navigation)
        btnNotificacao = findViewById(R.id.btn_notificacao)

        configurarEventos()
    }

    fun configurarEventos() {
        // Eventos para cada usuário
        usuario1.setOnClickListener {
            val intent = Intent(this, GerenciamentoDoAluno_Funcionario::class.java)
            startActivity(intent)
        }

        usuario2.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario3.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario4.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario5.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario6.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario7.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario8.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario9.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario10.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario11.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }

        usuario12.setOnClickListener {
            val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
            startActivity(intent)
        }


        btnNotificacao.setOnClickListener {
            val intent = Intent(this, TelaNotificacao_funcionario::class.java)
            startActivity(intent)
        }


        btnNavegacao.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    // O que acontece quando o item "Início" é clicado (permanece na tela atual)
                    true
                }

                R.id.nav_chat -> {
                    // Abre a tela de chat
                    val intent = Intent(this, TelaChat_funcionario::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_config -> {
                    // Abre a tela de configurações
                    val intent = Intent(this, TelaConfig::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }


}





/*// Array que indica se o usuário tem dados ou não (pode ser em SharedPreferences ou simples array)
       private val usuariosExistentes = BooleanArray(12) { false } // Definindo todos os usuários como novos inicialmente

   */





/*for (i in 0 until gridLayout.childCount) {
            val child = gridLayout.getChildAt(i)
            child.setOnClickListener {
                // Verifica se o usuário já existe (tem dados salvos)
                if (usuariosExistentes[i]) {
                    // Se for um usuário existente, abre a tela de gerenciamento de aluno com dados
                    val intent = Intent(this, GerenciamentoDoAluno_Funcionario::class.java)
                    intent.putExtra("user_id", i) // Passando o ID do usuário
                    startActivity(intent)
                } else {
                    // Se for um usuário novo, abre a tela de criação de dados
                    val intent = Intent(this, TelaGerenciamentoAlunoNovo_Funcionario::class.java)
                    intent.putExtra("user_id", i) // Passando o ID do usuário
                    startActivity(intent)
                }
            }
        }*/