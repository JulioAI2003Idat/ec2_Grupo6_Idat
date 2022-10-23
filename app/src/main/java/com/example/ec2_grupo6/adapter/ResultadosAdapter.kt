package com.example.ec2_grupo6.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ec2_grupo6.R
import com.example.ec2_grupo6.model.Libro
import kotlinx.android.synthetic.main.item_libro.view.*
import kotlinx.android.synthetic.main.item_resultado.view.*

class ResultadosAdapter(private val mContext: Context, private val lista:ArrayList<List<String>>):
    ArrayAdapter<List<String>>(mContext,0,lista){



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_resultado, parent, false)

        var resultado = lista[position]

        layout.tv1.text = resultado[0]
        layout.tv2.text = resultado[1]
        layout.tv3.text = resultado[2]
        layout.tv4.text = resultado[3]
        layout.tv5.text = resultado[4]
        layout.tv6.text = resultado[5]
        layout.tv7.text = resultado[6]

        return  layout
    }
}