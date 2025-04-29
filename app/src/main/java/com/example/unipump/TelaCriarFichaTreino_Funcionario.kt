package com.example.unipump

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaCriarFichaTreino_Funcionario : AppCompatActivity() {

    private lateinit var btnNavegacao : BottomNavigationView

    lateinit var btnSetaVoltar: ImageButton
    lateinit var spinnerGrupoMuscular: Spinner // Declarando o Spinner

    lateinit var btnAddExercio1: ImageButton
    lateinit var btnAddExercio2: ImageButton
    lateinit var btnAddExercio3: ImageButton
    lateinit var btnAddExercio4: ImageButton
    lateinit var btnAddExercio5: ImageButton


    lateinit var textLetraFicha: TextView
    lateinit var textNomeFicha: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_criar_ficha_treino_funcionario)

        btnNavegacao = findViewById(R.id.bottom_navigation)

        // Inicializando os componentes
        btnSetaVoltar = findViewById(R.id.SetaVoltarTelaCriarFicha)
        spinnerGrupoMuscular = findViewById(R.id.spinnerGrupoMuscular) // Inicializando o Spinner

        btnAddExercio1 = findViewById(R.id.btnAddExercio1_telaCriar)
        btnAddExercio2 = findViewById(R.id.btnAddExercio2_telaCriar)
        btnAddExercio3 = findViewById(R.id.btnAddExercio3_telaCriar)
        btnAddExercio4 = findViewById(R.id.btnAddExercio4_telaCriar)
        btnAddExercio5 = findViewById(R.id.btnAddExercio5_telaCriar)

        textLetraFicha = findViewById(R.id.letraFicha)
        textNomeFicha = findViewById(R.id.nomeFicha)



        val tipoFicha = intent.getStringExtra("ficha")
        val nomeFicha = intent.getStringExtra("nomeFicha")
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
        intent.getStringExtra(nomeFicha)


        configurarEventos()




        // Configurando o Spinner com os dados
        val gruposMusculares = listOf("Peito", "Costas", "Bíceps", "Tríceps", "Pernas")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gruposMusculares)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGrupoMuscular.adapter = adapter



    }

    fun configurarEventos() {

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


        val tipoFicha = intent.getStringExtra("ficha")
        val nomeFicha = intent.getStringExtra("nomeFicha")

        // Definindo o clique do botão de voltar
        btnSetaVoltar.setOnClickListener {
            onBackPressed() // Isso chama o comportamento de voltar para a tela anterior
        }

        btnAddExercio1.setOnClickListener {
            // Pega o layout pai do botão
            val parentLayout = it.parent as LinearLayout

            // Pega o TextView que está dentro desse LinearLayout (no caso, é o TextView do nome do exercício)
            val nomeExercicioTextView = parentLayout.findViewById<TextView>(R.id.nomeExercicio1)

            // Pega o texto do TextView
            val nomeExercicio = nomeExercicioTextView.text.toString()


            val intent = Intent(this, TelaCriarFichaTreino2_Funcionario::class.java)

            intent.putExtra("nomeExercicio", nomeExercicio)  // Passa o nome do exercício para a próxima tela

            if (tipoFicha == "A") {
                intent.putExtra("ficha" , "A")
                intent.putExtra("nomeFicha", "Costas e Bíceps")
            } else if (tipoFicha == "B"){
                intent.putExtra("ficha" , "B")
                intent.putExtra("nomeFicha", "Peito e Tríceps")
            }
            startActivity(intent)
        }
        btnAddExercio2.setOnClickListener {

            // Pega o layout pai do botão
            val parentLayout = it.parent as LinearLayout

            // Pega o TextView que está dentro desse LinearLayout (no caso, é o TextView do nome do exercício)
            val nomeExercicioTextView = parentLayout.findViewById<TextView>(R.id.nomeExercicio2)

            // Pega o texto do TextView
            val nomeExercicio = nomeExercicioTextView.text.toString()


            val intent = Intent(this, TelaCriarFichaTreino2_Funcionario::class.java)

            intent.putExtra("nomeExercicio", nomeExercicio)  // Passa o nome do exercício para a próxima tela

            if (tipoFicha == "A") {
                intent.putExtra("ficha" , "A")
                intent.putExtra("nomeFicha", "Costas e Bíceps")
            } else if (tipoFicha == "B"){
                intent.putExtra("ficha" , "B")
                intent.putExtra("nomeFicha", "Peito e Tríceps")
            }
            startActivity(intent)
        }


        btnAddExercio3.setOnClickListener {

            // Pega o layout pai do botão
            val parentLayout = it.parent as LinearLayout

            // Pega o TextView que está dentro desse LinearLayout (no caso, é o TextView do nome do exercício)
            val nomeExercicioTextView = parentLayout.findViewById<TextView>(R.id.nomeExercicio3)

            // Pega o texto do TextView
            val nomeExercicio = nomeExercicioTextView.text.toString()


            val intent = Intent(this, TelaCriarFichaTreino2_Funcionario::class.java)

            intent.putExtra("nomeExercicio", nomeExercicio)  // Passa o nome do exercício para a próxima tela

            if (tipoFicha == "A") {
                intent.putExtra("ficha" , "A")
                intent.putExtra("nomeFicha", "Costas e Bíceps")
            } else if (tipoFicha == "B"){
                intent.putExtra("ficha" , "B")
                intent.putExtra("nomeFicha", "Peito e Tríceps")
            }
            startActivity(intent)
        }

        btnAddExercio4.setOnClickListener {
            // Pega o layout pai do botão
            val parentLayout = it.parent as LinearLayout

            // Pega o TextView que está dentro desse LinearLayout (no caso, é o TextView do nome do exercício)
            val nomeExercicioTextView = parentLayout.findViewById<TextView>(R.id.nomeExercicio4)

            // Pega o texto do TextView
            val nomeExercicio = nomeExercicioTextView.text.toString()


            val intent = Intent(this, TelaCriarFichaTreino2_Funcionario::class.java)

            intent.putExtra("nomeExercicio", nomeExercicio)  // Passa o nome do exercício para a próxima tela

            if (tipoFicha == "A") {
                intent.putExtra("ficha" , "A")
                intent.putExtra("nomeFicha", "Costas e Bíceps")
            } else if (tipoFicha == "B"){
                intent.putExtra("ficha" , "B")
                intent.putExtra("nomeFicha", "Peito e Tríceps")
            }
            startActivity(intent)
        }

        btnAddExercio5.setOnClickListener {
            // Pega o layout pai do botão
            val parentLayout = it.parent as LinearLayout

            // Pega o TextView que está dentro desse LinearLayout (no caso, é o TextView do nome do exercício)
            val nomeExercicioTextView = parentLayout.findViewById<TextView>(R.id.nomeExercicio5)

            // Pega o texto do TextView
            val nomeExercicio = nomeExercicioTextView.text.toString()


            val intent = Intent(this, TelaCriarFichaTreino2_Funcionario::class.java)

            intent.putExtra("nomeExercicio", nomeExercicio)  // Passa o nome do exercício para a próxima tela

            if (tipoFicha == "A") {
                intent.putExtra("ficha" , "A")
                intent.putExtra("nomeFicha", "Costas e Bíceps")
            } else if (tipoFicha == "B"){
                intent.putExtra("ficha" , "B")
                intent.putExtra("nomeFicha", "Peito e Tríceps")
            }
            startActivity(intent)
        }



    }
}