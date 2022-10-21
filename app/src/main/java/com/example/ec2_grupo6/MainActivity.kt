package com.example.ec2_grupo6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ec2_grupo6.dao.PacienteDao
import com.example.ec2_grupo6.dao.PacienteService
import com.example.ec2_grupo6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnregistrar.setOnClickListener(this)
        binding.btnformulario.setOnClickListener(this)
        binding.btnlistado.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnregistrar -> irRegistro()
            R.id.btnformulario -> irFormulario()
            R.id.btnlistado -> irListado()

        }
    }

    private fun irListado() {
        val intent = Intent(this, ListadoActivity::class.java)
        startActivity(intent)
    }

    private fun irFormulario() {
        val intent = Intent(this, FormularioActivity::class.java)
        startActivity(intent)

    }

    private fun irRegistro() {
        val intent = Intent(this,RegistroActivity::class.java)
        startActivity(intent)
    }
}

