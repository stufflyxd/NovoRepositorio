package com.example.unipump

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.View.generateViewId
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaEdicaoFichaTreino_funcionario : AppCompatActivity() {

    private lateinit var btnNavegacao : BottomNavigationView

    lateinit var btnSetaVoltar: ImageButton

    lateinit var btnAdicionarFicha: Button

    lateinit var btnAddExercio1: ImageButton
    lateinit var btnAddExercio2: ImageButton


    lateinit var btnLixeiraExercio1: ImageButton
    lateinit var btnLixeiraExercio2: ImageButton
    lateinit var btnLixeiraExercio3: ImageButton

    lateinit var buttonExcluirSerie1: ImageButton
    lateinit var buttonExcluirSerie2: ImageButton
    lateinit var buttonExcluirSerie3: ImageButton
    lateinit var buttonExcluirSerie4: ImageButton
    lateinit var buttonExcluirSerie5: ImageButton
    lateinit var buttonExcluirSerie6: ImageButton
    lateinit var buttonExcluirSerie7: ImageButton
    lateinit var buttonExcluirSerie8: ImageButton

    lateinit var exercio1: LinearLayout
    lateinit var exercio2: LinearLayout
    lateinit var exercio3: LinearLayout

    lateinit var serie1: LinearLayout
    lateinit var serie2: LinearLayout
    lateinit var serie3: LinearLayout
    lateinit var serie4: LinearLayout
    lateinit var serie5: LinearLayout
    lateinit var serie6: LinearLayout
    lateinit var serie7: LinearLayout
    lateinit var serie8: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_edicao_ficha_treino_funcionario)

        btnNavegacao = findViewById(R.id.bottom_navigation)

        btnSetaVoltar = findViewById(R.id.SetaVoltarTelaEdicaoFicha)

        btnAdicionarFicha = findViewById(R.id.btnAdicionar)

        btnAddExercio1 = findViewById(R.id.btnAddExercico1)
        btnAddExercio2 = findViewById(R.id.btnAddExercico2)

        btnLixeiraExercio1 = findViewById(R.id.btnLixeiraExercio1)
        btnLixeiraExercio2 = findViewById(R.id.btnLixeiraExercio2)
        btnLixeiraExercio3 = findViewById(R.id.btnLixeiraExercio3)

        buttonExcluirSerie1 = findViewById(R.id.buttonExcluirSerie1)
        buttonExcluirSerie2 = findViewById(R.id.buttonExcluirSerie2)
        buttonExcluirSerie3 = findViewById(R.id.buttonExcluirSerie3)
        buttonExcluirSerie4 = findViewById(R.id.buttonExcluirSerie4)
        buttonExcluirSerie5 = findViewById(R.id.buttonExcluirSerie5)
        buttonExcluirSerie6 = findViewById(R.id.buttonExcluirSerie6)
        buttonExcluirSerie7 = findViewById(R.id.buttonExcluirSerie7)
        buttonExcluirSerie8 = findViewById(R.id.buttonExcluirSerie8)


        exercio1 = findViewById(R.id.exercio1)
        exercio2 = findViewById(R.id.exercio2)
        exercio3 = findViewById(R.id.exercio3)

        serie1 = findViewById(R.id.serie1)
        serie2 = findViewById(R.id.serie2)
        serie3 = findViewById(R.id.serie3)
        serie4 = findViewById(R.id.serie4)
        serie5 = findViewById(R.id.serie5)
        serie6 = findViewById(R.id.serie6)
        serie7 = findViewById(R.id.serie7)
        serie8 = findViewById(R.id.serie8)

        configurarEventos()
    }

    fun configurarEventos() {



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

        btnAddExercio1.setOnClickListener {
            val intent = Intent(this, TelaCriarFichaTreino_Funcionario::class.java)
            intent.putExtra("ficha" , "A")
            intent.putExtra("nomeFicha", "Costas e Bíceps")
            startActivity(intent)
        }

        btnAddExercio2.setOnClickListener {
            val intent = Intent(this, TelaCriarFichaTreino_Funcionario::class.java)
            intent.putExtra("ficha" , "B")
            intent.putExtra("nomeFicha", "Peito e Tríceps")
            startActivity(intent)
        }




        // Definindo o clique do botão de voltar
        btnSetaVoltar.setOnClickListener {
            onBackPressed() // Isso chama o comportamento de voltar para a tela anterior
        }


        btnLixeiraExercio1.setOnClickListener {
            excluirLinearLayout(exercio1)
        }

        btnLixeiraExercio2.setOnClickListener {
            excluirLinearLayout(exercio2)
        }

        btnLixeiraExercio2.setOnClickListener {
            excluirLinearLayout(exercio3)
        }


        // Configurando os botões de excluir série
        buttonExcluirSerie1.setOnClickListener {
            excluirLinearLayout(serie1)
        }

        buttonExcluirSerie2.setOnClickListener {
            excluirLinearLayout(serie2)
        }

        buttonExcluirSerie3.setOnClickListener {
            excluirLinearLayout(serie3)
        }

        buttonExcluirSerie4.setOnClickListener {
            excluirLinearLayout(serie4)
        }

        buttonExcluirSerie5.setOnClickListener {
            excluirLinearLayout(serie5)
        }

        buttonExcluirSerie6.setOnClickListener {
            excluirLinearLayout(serie6)
        }

        buttonExcluirSerie7.setOnClickListener {
            excluirLinearLayout(serie7)
        }

        buttonExcluirSerie8.setOnClickListener {
            excluirLinearLayout(serie8)
        }

        btnAdicionarFicha.setOnClickListener {
            adicionarNovaFicha()
        }
    }

    fun adicionarNovaFicha() {
        // Criar o LinearLayout principal (Ficha2)
        val novaFicha = LinearLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.largura_ficha), // 345dp
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER_HORIZONTAL
                setMargins(
                    0,
                    resources.getDimensionPixelSize(R.dimen.margem_superior_ficha), // 24dp
                    0,
                    resources.getDimensionPixelSize(R.dimen.margem_inferior_ficha) // 16dp
                )
            }
            orientation = LinearLayout.VERTICAL
            background = resources.getDrawable(R.drawable.conteiner_funcionario, null)
            setPadding(0, 0, 0, resources.getDimensionPixelSize(R.dimen.padding_inferior_ficha)) // 20dp
            id = generateViewId()
        }

        // Criar o LinearLayout do título
        val layoutTitulo = LinearLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    resources.getDimensionPixelSize(R.dimen.margem_horizontal_titulo), // 20dp
                    resources.getDimensionPixelSize(R.dimen.margem_superior_titulo), // 15dp
                    resources.getDimensionPixelSize(R.dimen.margem_horizontal_titulo), // 20dp
                    0
                )
            }
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
        }

        // Criar o EditText da letra (B)
        val editLetra = EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                marginEnd = resources.getDimensionPixelSize(R.dimen.margem_direita_letra) // 8dp
            }
            setText("B")
            setTextColor(resources.getColor(R.color.azul, null))
            textSize = 45f
            setTypeface(typeface, Typeface.BOLD)
            maxLines = 1
            inputType = InputType.TYPE_CLASS_TEXT
        }

        // Criar o EditText do nome (Peito e Triceps)
        val editNome = EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )
            backgroundTintList = resources.getColorStateList(R.color.cinza_escuro, null)
            setText("Peito e Triceps")
            setTextColor(resources.getColor(R.color.branco, null))
            textSize = 20f
        }

        // Criar o botão de adicionar exercício
        val btnAdicionarExercicio = ImageButton(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            backgroundTintList = resources.getColorStateList(R.color.cinza_escuro, null)
            setImageResource(R.drawable.plus_circle)
            contentDescription = "Botão de adicionar exercício"
            id = generateViewId()

            // Configurar clique para abrir tela de criação de exercício
            setOnClickListener {
                val intent = Intent(this@TelaEdicaoFichaTreino_funcionario,
                    TelaCriarFichaTreino_Funcionario::class.java)
                intent.putExtra("ficha", "B")
                intent.putExtra("nomeFicha", "Peito e Tríceps")
                startActivity(intent)
            }
        }

        // Criar a linha separadora
        val linhaSeparadora = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.altura_linha) // 2dp
            ).apply {
                setMargins(0, resources.getDimensionPixelSize(R.dimen.margem_superior_linha), 0, 0) // 10dp
            }
            setBackgroundColor(resources.getColor(android.R.color.darker_gray, null))
        }

        // Adicionar views aos seus pais
        layoutTitulo.addView(editLetra)
        layoutTitulo.addView(editNome)
        layoutTitulo.addView(btnAdicionarExercicio)

        novaFicha.addView(layoutTitulo)
        novaFicha.addView(linhaSeparadora)

        // Adicionar a nova ficha ao container principal
        val container = findViewById<ViewGroup>(R.id.containerFichas) // Você precisa ter este container no seu layout
        container.addView(novaFicha)
    }

    // Função para excluir o LinearLayout pai
    fun excluirLinearLayout(linearLayout: LinearLayout) {
        // Verifica se o parent é um ViewGroup e então remove a View
        (linearLayout.parent as? ViewGroup)?.removeView(linearLayout)
    }
}