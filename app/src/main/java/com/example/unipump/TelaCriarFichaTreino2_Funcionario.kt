package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.view.View.generateViewId
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaCriarFichaTreino2_Funcionario : AppCompatActivity() {

    private lateinit var btnNavegacao : BottomNavigationView

    lateinit var btnSetaVoltar: ImageButton

    lateinit var btnAdicionarFicha: Button


    lateinit var textLetraFicha: TextView
    lateinit var textNomeFicha: TextView
    lateinit var textNomeExercicio: TextView

    lateinit var btnAddExercicio: ImageButton
    lateinit var btnExcluirSerie1: ImageButton
    lateinit var btnExcluirSerie2: ImageButton
    lateinit var btnExcluirSerie3: ImageButton
    lateinit var serie1: LinearLayout
    lateinit var serie2: LinearLayout
    lateinit var serie3: LinearLayout
    lateinit var conteinerSerie: LinearLayout

    private var serieCount = 3 // Começa com 3 porque já temos 3 séries iniciais

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_criar_ficha_treino2_funcionario)

        btnNavegacao = findViewById(R.id.bottom_navigation)

        btnAdicionarFicha = findViewById(R.id.btnAdicionar)

        btnSetaVoltar = findViewById(R.id.SetaVoltarTelaCriarFicha2)

        textLetraFicha = findViewById(R.id.letraFicha)
        textNomeFicha = findViewById(R.id.nomeFicha)
        textNomeExercicio = findViewById(R.id.txtNomeExercicio)

        btnAddExercicio = findViewById(R.id.btnAddExercio_telaCriar2)
        btnExcluirSerie1 = findViewById(R.id.btnExcluirSerie1)
        btnExcluirSerie2 = findViewById(R.id.btnExcluirSerie2)
        btnExcluirSerie3 = findViewById(R.id.btnExcluirSerie3)
        serie1 = findViewById(R.id.serie1)
        serie2 = findViewById(R.id.serie2)
        serie3 = findViewById(R.id.serie3)
        conteinerSerie = findViewById(R.id.conteinerSerie)

        configurarEventos()


        val tipoFicha = intent.getStringExtra("ficha")
        val nomeFicha = intent.getStringExtra("nomeFicha")
        val nomeExercicio = intent.getStringExtra("nomeExercicio") // Recuperando o nome do exercício


        // Verificando o tipo de ficha e alterando os TextViews

        if (tipoFicha == "A") {
            textLetraFicha.text = "A"  // Atualiza o TextView letraFicha com "A"
        } else if (tipoFicha == "B") {
            textLetraFicha.text = "B"  // Atualiza o TextView letraFicha com "A"
        }

        /*when (tipoFicha) {
            "A" -> textLetraFicha.text = "A" // Se for A, exibe A
            "B" -> textLetraFicha.text = "B"  // Se for B, exibe B
        }*/

        // Atualiza o TextView nomeFicha com o nome recebido da Intent
        textNomeFicha.text = nomeFicha

        // Atualiza o TextView nomeExercicio com o nome do exercício recebido da Intent
        textNomeExercicio.text = nomeExercicio

    }

    fun configurarEventos() {


        btnAdicionarFicha.setOnClickListener {

            // Captura o nome do exercício
            val nomeExercicio = findViewById<TextView>(R.id.txtNomeExercicio).text.toString()

            // Criar listas para armazenar as repetições, pesos, e tempos das séries
            val repeticoes = mutableListOf<String>()
            val pesos = mutableListOf<String>()
            val tempos = mutableListOf<String>()

            // Percorre cada LinearLayout da série dentro do container
            for (i in 0 until conteinerSerie.childCount) {
                val serieLayout = conteinerSerie.getChildAt(i) as LinearLayout

                // Pegando os EditTexts diretamente pelas IDs específicas de cada campo
                val repeticoesEditText = serieLayout.findViewById<EditText>(R.id.editRepeticoes1 + i)
                val pesoEditText = serieLayout.findViewById<EditText>(R.id.editPeso1 + i)
                val tempoEditText = serieLayout.findViewById<EditText>(R.id.editTempo1 + i)

                // Adiciona os dados às listas
                repeticoes.add(repeticoesEditText.text.toString())
                pesos.add(pesoEditText.text.toString())
                tempos.add(tempoEditText.text.toString())
            }

            // Criar a Intent e enviar os dados para a próxima tela
            val intent = Intent(this, TelaEdicaoFichaTreino_funcionario::class.java).apply {
                putExtra("nomeExercicio", nomeExercicio)
                putExtra("repeticoes", repeticoes.toTypedArray()) // Passando as repetições
                putExtra("pesos", pesos.toTypedArray()) // Passando os pesos
                putExtra("tempos", tempos.toTypedArray()) // Passando os tempos
                putExtra("tipoFicha", intent.getStringExtra("ficha")) // Passando o tipo de ficha (A ou B)
            }

            /* // Enviar também o tipo de ficha, se necessário
             val tipoFicha = intent.getStringExtra("ficha")
             if (tipoFicha != null) {
                 intent.putExtra("ficha", tipoFicha)
             }
 */
            // Iniciar a próxima Activity
            startActivity(intent)
        }



        btnNavegacao.setOnNavigationItemSelectedListener { item ->
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



        btnSetaVoltar.setOnClickListener {
            onBackPressed()
        }

        btnExcluirSerie1.setOnClickListener {
            excluirLinearLayout(serie1)
        }

        btnExcluirSerie2.setOnClickListener {
            excluirLinearLayout(serie2)
        }

        btnExcluirSerie3.setOnClickListener {
            excluirLinearLayout(serie3)
        }

        btnAddExercicio.setOnClickListener {
            adicionarNovaSerie()
        }
    }

    fun excluirLinearLayout(linearLayout: LinearLayout) {
        (linearLayout.parent as? ViewGroup)?.removeView(linearLayout)
    }
    private fun adicionarNovaSerie() {
        // Cria um novo LinearLayout com as mesmas propriedades das séries existentes
        val novaSerie = LinearLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    resources.getDimensionPixelSize(R.dimen.serie_margin_horizontal),
                    resources.getDimensionPixelSize(R.dimen.serie_margin_top),
                    resources.getDimensionPixelSize(R.dimen.serie_margin_horizontal),
                    0
                )
            }

            orientation = LinearLayout.HORIZONTAL
            gravity = android.view.Gravity.CENTER_VERTICAL
            background = resources.getDrawable(R.drawable.rounded_edittext, null)
            backgroundTintList = resources.getColorStateList(R.color.black, null)
            setPadding(
                resources.getDimensionPixelSize(R.dimen.serie_padding),
                resources.getDimensionPixelSize(R.dimen.serie_padding),
                resources.getDimensionPixelSize(R.dimen.serie_padding),
                resources.getDimensionPixelSize(R.dimen.serie_padding)
            )
            weightSum = 1f
            id = generateViewId()
        }

        // Adiciona o número da série (pode ser retirado caso não queira usar a contagem)
        TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                marginEnd = resources.getDimensionPixelSize(R.dimen.serie_number_margin)
            }
            text = (conteinerSerie.childCount + 1).toString()  // Número da série com base no número de filhos no container
            setTextColor(resources.getColor(R.color.white, null))
            textSize = 28f
            novaSerie.addView(this)
        }

        // Adiciona o campo de repetições
        EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.repetition_width),
                resources.getDimensionPixelSize(R.dimen.field_height)
            ).apply {
                marginEnd = resources.getDimensionPixelSize(R.dimen.field_margin)
            }
            background = resources.getDrawable(R.drawable.rounded_edittext, null)
            backgroundTintList = resources.getColorStateList(R.color.field_background, null)
            setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.icon_repeticao, 0, 0, 0
            )
            compoundDrawablePadding = resources.getDimensionPixelSize(R.dimen.icon_padding)
            setTextColor(resources.getColor(R.color.white, null))
            setText("10")
            textSize = 16f
            inputType = android.text.InputType.TYPE_CLASS_NUMBER
            setPadding(
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding)
            )
            novaSerie.addView(this)
        }

        // Adiciona o campo de peso
        EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.weight_width),
                resources.getDimensionPixelSize(R.dimen.field_height)
            ).apply {
                marginEnd = resources.getDimensionPixelSize(R.dimen.field_margin)
            }
            background = resources.getDrawable(R.drawable.rounded_edittext, null)
            backgroundTintList = resources.getColorStateList(R.color.field_background, null)
            setTextColor(resources.getColor(R.color.white, null))
            setText("10 Kg")
            textSize = 16f
            setPadding(
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding)
            )
            novaSerie.addView(this)
        }

        // Adiciona o campo de tempo
        EditText(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.time_width),
                resources.getDimensionPixelSize(R.dimen.field_height)
            ).apply {
                marginEnd = resources.getDimensionPixelSize(R.dimen.time_margin)
            }
            background = resources.getDrawable(R.drawable.rounded_edittext, null)
            backgroundTintList = resources.getColorStateList(R.color.field_background, null)
            setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.icon_relogio, 0, 0, 0
            )
            compoundDrawablePadding = resources.getDimensionPixelSize(R.dimen.icon_padding)
            setTextColor(resources.getColor(R.color.white, null))
            setText("10")
            textSize = 16f
            setPadding(
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding),
                resources.getDimensionPixelSize(R.dimen.field_padding)
            )
            novaSerie.addView(this)
        }

        // Adiciona o botão de excluir
        ImageButton(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                resources.getDimensionPixelSize(R.dimen.delete_button_size),
                resources.getDimensionPixelSize(R.dimen.delete_button_size)
            ).apply {
                marginStart = resources.getDimensionPixelSize(R.dimen.delete_button_margin)
            }
            setImageResource(R.drawable.icon_lixeiro)
            backgroundTintList = resources.getColorStateList(R.color.black, null)
            contentDescription = "Botão de excluir série"
            setOnClickListener {
                excluirLinearLayout(novaSerie)
            }
            novaSerie.addView(this)
        }

        // Adiciona a nova série diretamente ao container
        conteinerSerie.addView(novaSerie)
    }
}