package com.example.ec2_grupo6.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ec2_grupo6.R
import com.example.ec2_grupo6.model.Libro

class LibrosAdapter(private val mContext: Context, private val listaLibros: List<Libro>): ArrayAdapter<Libro>(mContext,0,listaLibros) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_libro,parent,false)

        val producto = listaLibros[position]


        return layout
    }
}