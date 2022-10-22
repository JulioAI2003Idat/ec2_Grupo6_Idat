package com.example.ec2_grupo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.ec2_grupo6.adapter.LibrosAdapter
import com.example.ec2_grupo6.databinding.ActivityListadoLibrosBinding
import com.example.ec2_grupo6.model.Libro
import kotlinx.android.synthetic.main.activity_listado_libros.*

class ListadoLibrosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoLibrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoLibrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val libro1= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro2= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro3= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro4= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro5= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro6= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro7= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro8= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro9= Libro("Romeo y Julieta","Drama-Romance","12-12-12")
        val libro10= Libro("Romeo y Julieta","Drama-Romance","12-12-12")

        val lista= listOf(libro1,libro2,libro3,libro4,libro5,libro6,libro7,libro8,libro9,libro10)

        val adapter= LibrosAdapter(this,lista)
        lvDatos.adapter=adapter
    }

}