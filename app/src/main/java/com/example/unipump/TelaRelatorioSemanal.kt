package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView


class TelaRelatorioSemanal : AppCompatActivity() {
    private lateinit var voltar: ImageButton
    private lateinit var todosReg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_relatorio_semanal)

        voltar = findViewById(R.id.SetaVoltarTelaCriarFicha)
        todosReg = findViewById(R.id.todosRegistros)
        configEventos()




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
                    val intent = Intent(this, TelaConfig:: class.java)
                    startActivity(intent)
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

    private fun configEventos(){
        voltar.setOnClickListener{
            finish()
        }

        todosReg.setOnClickListener {
            val intent = Intent(this, TelaDadosDeTreino:: class.java)
            startActivity(intent)
        }
    }






}
