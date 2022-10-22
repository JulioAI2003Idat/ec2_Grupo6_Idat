package com.example.ec2_grupo6

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ec2_grupo6.model.Libro

class LibroAdapter(
    private val mContext: Context,
    private val listaLibros: List<Libro>): ArrayAdapter<Libro>(mContext,0,listaLibros)


     {
}