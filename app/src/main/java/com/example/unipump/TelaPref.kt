package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaPref : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_pref)

        val backButton: ImageView = findViewById(R.id.SetaVoltarTelaCriarFicha)
        val languageOption: TextView = findViewById(R.id.language_option)
        val themeSwitch: Switch = findViewById(R.id.theme_switch)
        val aboutOption: TextView = findViewById(R.id.about_option)
        val clearCacheOption: TextView = findViewById(R.id.clear_cache_option)



        // Botao voltar
        backButton.setOnClickListener {
            finish()
        }

        // Idioma
        languageOption.setOnClickListener {
            val intent = Intent(this, TelaIdioma::class.java)
            startActivity(intent)
            // abrir uma de selecionar o idioma
        }

        // Switch tema
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Tema Escuro ativado", Toast.LENGTH_SHORT).show()
                // alterar tema escuro
            } else {
                Toast.makeText(this, "Tema Claro ativado", Toast.LENGTH_SHORT).show()
                // tema claro
            }
        }

        // sobre
        aboutOption.setOnClickListener {
            val intent = Intent(this, TelaSobre::class.java)
            startActivity(intent)
        }

        // limpar cache
        clearCacheOption.setOnClickListener {
            Toast.makeText(this, "Cache limpo", Toast.LENGTH_SHORT).show()
            // implementar a limpeza do cache
        }






    }
}