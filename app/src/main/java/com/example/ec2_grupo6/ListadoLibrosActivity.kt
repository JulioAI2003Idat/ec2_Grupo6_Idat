package com.example.ec2_grupo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ec2_grupo6.adapter.LibrosAdapter
import com.example.ec2_grupo6.model.Libro
import kotlinx.android.synthetic.main.activity_listado.*
import kotlinx.android.synthetic.main.activity_listado_libros.*

class ListadoLibrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_libros)

        val libro1 = Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro2 = Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro3= Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro4 = Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro5 = Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro6 = Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro7 = Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro8 = Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro9 = Libro("libro","para leer","22/12/2003",R.drawable.img)
        val libro10 = Libro("libro","para leer","22/12/2003",R.drawable.img)

        val listalibros = listOf(libro1,libro2,libro3,libro4,libro5,libro6,libro7,libro8,libro9,libro10)

        val adapter = LibrosAdapter(this,listalibros)

        lvlibros.adapter = adapter


    }
}