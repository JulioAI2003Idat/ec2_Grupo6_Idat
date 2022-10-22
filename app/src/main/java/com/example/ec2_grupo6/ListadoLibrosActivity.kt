package com.example.ec2_grupo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.ec2_grupo6.databinding.ActivityListadoLibrosBinding

class ListadoLibrosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoLibrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoLibrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayAdapter:ArrayAdapter<*>//con el * indicas que el tipo de dato es de cualquier tipo

        val libros = mutableListOf("Libro de cardiologia","Libro de anemia","Libro de tuberculosis")
        val lvDatos = binding.lvDatos

        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,libros)
        lvDatos.adapter = arrayAdapter

        lvDatos.setOnItemClickListener(){parent, view,position,id ->
            Toast.makeText(this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show()
        }
    }

}