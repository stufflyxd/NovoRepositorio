package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class GerenciamentoDoAluno_Funcionario : AppCompatActivity() {

    private lateinit var linkModificar: TextView
    private lateinit var linkMaisDetalhes: TextView
    private lateinit var btnSetaVoltar : ImageButton
    private lateinit var btnNavegacao : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gerenciamento_do_aluno_antigo_funcionario)

        linkMaisDetalhes = findViewById(R.id.link_mais_detalhes)
        linkModificar = findViewById(R.id.link_modificar)
        btnSetaVoltar = findViewById(R.id.SetaVoltarTelaGerenciamentoAluno)
        btnNavegacao = findViewById(R.id.bottom_navigation)

        configurarEventos()
    }

    fun configurarEventos(){

        linkMaisDetalhes.setOnClickListener{
            val intent = Intent(this, TelaInformacaoPessoal_funcionario::class.java)
            startActivity(intent)

        }

        linkModificar.setOnClickListener{
            val intent = Intent(this, TelaEdicaoFichaTreino_funcionario::class.java)
            startActivity(intent)

        }

        // Definindo o clique do botão de voltar
        btnSetaVoltar.setOnClickListener {
            onBackPressed() // Isso chama o comportamento de voltar para a tela anterior
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




/*
linkModificar.setOnClickListener{
    // Criação do AlertDialog
    val builder = AlertDialog.Builder(this)
    builder.setTitle("Divisão de Treinos")

    // Criação dos Checkboxes
    val checkBoxA = CheckBox(this)
    checkBoxA.text = "Ficha A"

    val checkBoxB = CheckBox(this)
    checkBoxB.text = "Ficha B"

    val checkBoxC = CheckBox(this)
    checkBoxC.text = "Ficha C"

    // Agrupando todos os Checkboxes em um LinearLayout
    val layout = LinearLayout(this)
    layout.orientation = LinearLayout.VERTICAL
    layout.addView(checkBoxA)
    layout.addView(checkBoxB)
    layout.addView(checkBoxC)

    // Adicionando o layout ao dialog
    builder.setView(layout)

    // Ação do botão "Adicionar Ficha"
    builder.setPositiveButton("Adicionar Ficha") { dialog, which ->
        // Verificando quais checkboxes estão selecionados
        var selectedOptions = "Fichas selecionadas: "

        if (checkBoxA.isChecked) {
            selectedOptions += "Ficha A, "
        }
        if (checkBoxB.isChecked) {
            selectedOptions += "Ficha B, "
        }
        if (checkBoxC.isChecked) {
            selectedOptions += "Ficha C, "
        }

        if (selectedOptions.endsWith(", ")) {
            selectedOptions = selectedOptions.substring(0, selectedOptions.length - 2)
        }

        // Exibir as fichas selecionadas
        Toast.makeText(this, selectedOptions, Toast.LENGTH_SHORT).show()
    }

    builder.setNegativeButton("Cancelar") { dialog, which ->
        dialog.dismiss() // Fecha o dialog sem fazer nada
    }

    // Exibindo o AlertDialog
    builder.create().show()
}*/