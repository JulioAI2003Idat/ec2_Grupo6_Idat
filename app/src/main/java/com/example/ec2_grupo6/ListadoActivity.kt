package com.example.ec2_grupo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.ec2_grupo6.databinding.ActivityListadoBinding
import android.R

class ListadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listapacientes  = intent.getSerializableExtra("listapacientes") as ArrayList<String>
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, listapacientes)

        binding.lvpacientes.adapter = adapter

    }
}