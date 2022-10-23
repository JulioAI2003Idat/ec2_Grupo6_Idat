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

        val libro1 = Libro("Compendio de Medicina de Urgencias","5a edición del Compendio de Medicina de Urgencias",
            "05/2002",R.drawable.libro)
        val libro2 = Libro("Medicina Interna Farreras - Rozman","Libro centrado en la medicina interna","05/2000",R.drawable.libro)
        val libro3= Libro("Atlas de Anatomía Humana","Nueva edicion del atlas de anatomía humana","1989",R.drawable.libro)
        val libro4 = Libro("Netter. Flashcards de anatomía","4ta edición del libro de las Flash Cards","18/03/2014",R.drawable.libro)
        val libro5 = Libro("Medicina de urgencias y emergencias","Libro enfocado en el diagnóstico y tratamiento de urgencias","06/1999",R.drawable.libro)
        val libro6 = Libro("Anatomía Con Orientación Clínica","Anatomía con orientación clínica","2011",R.drawable.libro)
        val libro7 = Libro("Tratado de fisiología médica","Nueva edición del best seller en Fisiología","1956",R.drawable.libro)
        val libro8 = Libro("Tratado de Medicina Oculta y Magia Práctica","Libro de Medicina","1952",R.drawable.libro)
        val libro9 = Libro("Tratado de cirugía general","Libro centrado en el estudio de cirugías","31/10/2016",R.drawable.libro)
        val libro10 = Libro("Terminología médica","Libro de Medicina","1983",R.drawable.libro)

        val listalibros = listOf(libro1,libro2,libro3,libro4,libro5,libro6,libro7,libro8,libro9,libro10)

        val adapter = LibrosAdapter(this,listalibros)

        lvlibros.adapter = adapter


    }
}