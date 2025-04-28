package com.example.unipump

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaIdioma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_idioma)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val languageListView: ListView = findViewById(R.id.language_list)

        // Opçoes de idioma
        val languages = listOf(
            "Portuguese (Português - BR)",
            "Polski (Polonês)",
            "English (Inglês - EUA)",
            "Español (Espanhol)",
            "Русский (Russo)",
            "Deutsch (Alemão)"
        )

        // Set up the ListView with an ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, languages)
        languageListView.adapter = adapter
        languageListView.choiceMode = ListView.CHOICE_MODE_SINGLE

        // Botao voltar
        backButton.setOnClickListener {
            finish()
        }

        // Handle item selection
        languageListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedLanguage = languages[position]
            Toast.makeText(this, "$selectedLanguage selecionado", Toast.LENGTH_SHORT).show()

            // Save the selected language preference (to be implemented later)
        }
    }
}