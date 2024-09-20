package com.cp.planejeja

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editNomeCurso: EditText
    private lateinit var editLinkCurso: EditText
    private lateinit var editDuracaoCurso: EditText
    private lateinit var btnAdicionarCurso: Button
    private lateinit var listViewCursos: ListView

    private val listaCursos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando as views
        editNomeCurso = findViewById(R.id.editNomeCurso)
        editLinkCurso = findViewById(R.id.editLinkCurso)
        editDuracaoCurso = findViewById(R.id.editDuracaoCurso)
        btnAdicionarCurso = findViewById(R.id.btnAdicionarCurso)
        listViewCursos = findViewById(R.id.listViewCursos)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCursos)
        listViewCursos.adapter = adapter

        btnAdicionarCurso.setOnClickListener {
            val nomeCurso = editNomeCurso.text.toString()
            val linkCurso = editLinkCurso.text.toString()
            val duracaoCurso = editDuracaoCurso.text.toString()

            if (nomeCurso.isNotEmpty() && linkCurso.isNotEmpty() && duracaoCurso.isNotEmpty()) {
                val curso = "$nomeCurso - $duracaoCurso horas\n$linkCurso"
                listaCursos.add(curso)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Curso adicionado!", Toast.LENGTH_SHORT).show()

                // Limpar campos após adicionar
                editNomeCurso.text.clear()
                editLinkCurso.text.clear()
                editDuracaoCurso.text.clear()
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
