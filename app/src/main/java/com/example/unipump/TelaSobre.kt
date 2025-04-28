package com.example.unipump

import android.os.Bundle
import android.widget.ImageView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class TelaSobre : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_sobre)

        val backButton: ImageView = findViewById(R.id.SetaVoltarTelaCriarFicha)

        backButton.setOnClickListener {
            finish()
        }
    }
}