package com.example.ec2_grupo6.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ec2_grupo6.R
import com.example.ec2_grupo6.model.Libro
import kotlinx.android.synthetic.main.item_libro.view.*


class LibrosAdapter(private val mContext: Context, private val listaLibros: List<Libro>): ArrayAdapter<Libro>(mContext,0,listaLibros) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_libro,parent,false)

        val producto = listaLibros[position]

        layout.txvtitulo.text= producto.titulo
        layout.txvdescripcion.text= producto.descripcion
        layout.txvfecha.text= producto.fecha_publi
        layout.imageView2.setImageResource(R.drawable.imglibro)

        return layout
    }
}