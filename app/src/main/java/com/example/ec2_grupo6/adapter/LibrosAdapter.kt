package com.example.ec2_grupo6.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ec2_grupo6.R
import com.example.ec2_grupo6.model.Libro
import kotlinx.android.synthetic.main.item_libro.view.*

class LibrosAdapter(private val mContext:Context, private val listalibros:List<Libro>): ArrayAdapter<Libro>(mContext,0,listalibros) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_libro,parent,false)

        val libro = listalibros[position]

        layout.txvtitulo.text = libro.titulo
        layout.txvdescripcion.text = libro.descripcion
        layout.txvfecha.text = libro.fecha
        layout.imagen.setImageResource(libro.imagen)

        return  layout

    }
}