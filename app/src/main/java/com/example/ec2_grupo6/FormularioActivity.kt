package com.example.ec2_grupo6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.example.ec2_grupo6.commom.AppMensaje
import com.example.ec2_grupo6.commom.TipoMensaje
import com.example.ec2_grupo6.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityFormularioBinding

    private var listarFormulario = ArrayList<String>()
    private var listarSintomas = ArrayList<String>()
    private var listarServicios = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setTitle(R.string.tituloFormulario);

        binding.cbdisminucion.setOnClickListener(this)
        binding.cbtos.setOnClickListener(this)
        binding.cbdolorgarganta.setOnClickListener(this)
        binding.cbcongestionnasal.setOnClickListener(this)
        binding.cbfiebre.setOnClickListener(this)
        binding.cbninguno.setOnClickListener(this)

        binding.cbluz.setOnClickListener(this)
        binding.cbagua.setOnClickListener(this)
        binding.cbinternet.setOnClickListener(this)
        binding.cbcable.setOnClickListener(this)

        binding.btnresolver.setOnClickListener(this)
        binding.btnlistar.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view is CheckBox) {
            if (view.id == binding.cbdisminucion.id
                || view.id == binding.cbtos.id
                || view.id == binding.cbdolorgarganta.id
                || view.id == binding.cbcongestionnasal.id
                || view.id == binding.cbfiebre.id
                || view.id == binding.cbninguno.id
            ) {
                añadirSintomas(view)
            } else {
                añadirServicios(view)
            }
        } else {
            when (view.id) {
                binding.btnresolver.id -> resolviendoFormulario()
                binding.btnlistar.id -> listaFormulario()
            }
        }
    }

    private fun resolviendoFormulario() {
        if (validacionFormulario()) {
            val datosFormulario = "Los Sintomas son:\n${listarSintomas.toString()}\n" +
                    "Fiebre mayor a 37°: ${respuestaFiebre()}\n" +
                    "Vives solo en casa: ${respuestaVivirSolo()}\n" +
                    "Vives con un adulto mayor: ${respuestaVivesConAdulto()}\n" +
                    "Servicios en el hogar: \n${listarServicios.toString()}"
            listarFormulario.add(datosFormulario)
            AppMensaje.enviarMensaje(binding.root,"Se guardaron los datos correctamente.", TipoMensaje.SUCCESSFULL)
            limpiarFormulario()
        }
    }

    private fun listaFormulario() {
        val intentFormulario = Intent(
            this, ListadoActivity::class.java
        ).apply {
            putExtra("listapacientes", listarFormulario)
        }
        startActivity(intentFormulario)
    }

    private fun limpiarFormulario() {
        binding.cbdisminucion.isChecked = false
        binding.cbtos.isChecked = false
        binding.cbdolorgarganta.isChecked = false
        binding.cbcongestionnasal.isChecked = false
        binding.cbfiebre.isChecked = false
        binding.cbninguno.isChecked = false
        binding.cbluz.isChecked = false
        binding.cbagua.isChecked = false
        binding.cbinternet.isChecked = false
        binding.cbcable.isChecked = false

        binding.rgfiebre.clearCheck()
        binding.rgvivessolocasa.clearCheck()
        binding.rgvivesadultomayorcasa.clearCheck()

        listarSintomas.clear()
        listarServicios.clear()
    }

    private fun validacionFormulario(): Boolean {
        if (!validacionSintomas()) {
            AppMensaje.enviarMensaje(binding.root, "Marcar sintomas", TipoMensaje.ALERTA)
            return false
        }

        if (!validacionFiebre()) {
            AppMensaje.enviarMensaje(
                binding.root,"Indica si es o no mayor a 37° grados de fiebre", TipoMensaje.ERROR)
            return false
        }

        if (!validacionVivesSolo()) {
            AppMensaje.enviarMensaje(binding.root, "Indica si es que vives solo", TipoMensaje.ERROR)
            return false
        }

        if (!validacionVivesAdultoMayor()) {
            AppMensaje.enviarMensaje(
                binding.root,"Indica si es que vives con un adulto mayor", TipoMensaje.ERROR)
            return false
        }

        if (!validacionServiciosHogar()) {
            AppMensaje.enviarMensaje(binding.root, "Marca que servicios tienes en tu hogar", TipoMensaje.ALERTA)
            return false
        }

        return true
    }

    private fun validacionSintomas(): Boolean {
        var rspta = false
        if (
            binding.cbdisminucion.isChecked ||
            binding.cbtos.isChecked ||
            binding.cbdolorgarganta.isChecked ||
            binding.cbcongestionnasal.isChecked ||
            binding.cbfiebre.isChecked ||
            binding.cbninguno.isChecked
        ) {
            rspta = true
        }
        return rspta
    }

    private fun validacionFiebre(): Boolean {
        var rspta = true
        if (binding.rgfiebre.checkedRadioButtonId == -1) {
            rspta = false
        }
        return rspta
    }

    private fun validacionVivesSolo(): Boolean {
        var rspta = true
        if (binding.rgvivessolocasa.checkedRadioButtonId == -1) {
            rspta = false
        }
        return rspta
    }

    private fun validacionVivesAdultoMayor(): Boolean {
        var rspta = true
        if (binding.rgvivesadultomayorcasa.checkedRadioButtonId == -1) {
            rspta = false
        }
        return rspta
    }

    private fun validacionServiciosHogar(): Boolean {
        var rspta = false
        if (
            binding.cbluz.isChecked ||
            binding.cbagua.isChecked ||
            binding.cbinternet.isChecked ||
            binding.cbcable.isChecked
        ) {
            rspta = true
        }
        return rspta
    }

    private fun respuestaFiebre(): String {
        var rspta = ""
        when (binding.rgfiebre.checkedRadioButtonId) {
            binding.rbfiebresi.id -> rspta = binding.rbfiebresi.text.toString()
            binding.rbfiebreno.id -> rspta = binding.rbfiebreno.text.toString()
        }
        return rspta
    }

    private fun respuestaVivirSolo(): String {
        var rspta = ""
        when (binding.rgvivessolocasa.checkedRadioButtonId) {
            binding.rbvivessolosi.id -> rspta = binding.rbvivessolosi.text.toString()
            binding.rbvivessolono.id -> rspta = binding.rbvivessolono.text.toString()
        }
        return rspta
    }

    private fun respuestaVivesConAdulto(): String {
        var rspta = ""
        when (binding.rgvivesadultomayorcasa.checkedRadioButtonId) {
            binding.rbadultomayorsi.id -> rspta = binding.rbadultomayorsi.text.toString()
            binding.rbadultomayorno.id -> rspta = binding.rbadultomayorno.text.toString()
        }
        return rspta
    }

    private fun añadirSintomas(checkBox: CheckBox) {
        if (checkBox.isChecked) {
            listarSintomas.add(checkBox.text.toString())
        } else {
            listarSintomas.remove(checkBox.text.toString())
        }
    }

    private fun añadirServicios(checkBox: CheckBox) {
        if (checkBox.isChecked) {
            listarServicios.add(checkBox.text.toString())
        } else {
            listarServicios.remove(checkBox.text.toString())
        }
    }

}