package com.example.ec2_grupo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.ec2_grupo6.databinding.ActivityListadoBinding
import android.R
import com.example.ec2_grupo6.adapter.ResultadosAdapter

class ListadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaresultados  = intent.getSerializableExtra("listaresultados") as ArrayList<List<String>>
        //val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, listapacientes)

        val adapter = ResultadosAdapter(this, listaresultados)
        binding.lvpacientes.adapter = adapter

    }
}