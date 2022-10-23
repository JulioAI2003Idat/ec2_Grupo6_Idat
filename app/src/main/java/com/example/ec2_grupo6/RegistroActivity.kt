package com.example.ec2_grupo6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import com.example.ec2_grupo6.commom.AppMensaje
import com.example.ec2_grupo6.commom.TipoMensaje
//import com.example.ec2_grupo6.dao.PacienteService
import com.example.ec2_grupo6.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityRegistroBinding
    private val listapacientes = ArrayList<String>()
    private val listapreferencias = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chkdeporte.setOnClickListener(this)
        binding.chkpintura.setOnClickListener(this)
        binding.chkotro.setOnClickListener(this)
        binding.btnacceder.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view is CheckBox){
            agregarQuitarPreferencias(view)
        }else{
            when(view.id){
                R.id.btnacceder -> RegistroPaciente()
            }
        }
    }

    private fun RegistroPaciente() {
        if (validarRegistro()){
            var paciente = "Nombres y apellidos: ${binding.etnombre.text} ${binding.etapellido.text}\n" +
                    "DNI: ${binding.etdni.text}\n" +
                    "Correo: ${binding.etemail.text}\n" +
                    "Contraseña: ${binding.etpassword.text}\n" +
                    "Género: ${obtenerGeneroSeleccionado()}\n" +
                    "Hobbies:\n${listapreferencias}\n" +
                    "Otro hobby: ${binding.ethobby.text}"
            listapacientes.add(paciente)
            var intent = Intent(this,ListadoActivity::class.java).apply {
                putExtra("listapacientes",listapacientes)
            }
            startActivity(intent)

            AppMensaje.enviarMensaje(binding.root,"Persona registrada correctamente",TipoMensaje.SUCCESSFULL)
            Reiniciarformulario()
        }
    }

    private fun Reiniciarformulario() {
        listapreferencias.clear()
        binding.etnombre.setText("")
        binding.etapellido.setText("")
        binding.etdni.setText("")
        binding.etemail.setText("")
        binding.etpassword.setText("")
        binding.ethobby.setText("")
        binding.chkdeporte.isChecked = false
        binding.chkpintura.isChecked = false
        binding.chkotro.isChecked = false
        binding.radioGroup.clearCheck()
        binding.etdni.isFocusableInTouchMode = true
        binding.etdni.requestFocus()
    }

    private fun obtenerGeneroSeleccionado():String {
        var genero=""
        when(binding.radioGroup.checkedRadioButtonId){
            R.id.rbhombre -> genero = binding.rbhombre.text.toString()
            R.id.rbmujer -> genero = binding.rbmujer.text.toString()
        }
        return genero
    }

    private fun validarRegistro(): Boolean {
        var rpta = false
        if (!validarDni()){
            AppMensaje.enviarMensaje(binding.root,"Ingrese el DNI, o verifique el n° de dígitos",TipoMensaje.ERROR)
        }else if (!validarNombreApellido()){
            AppMensaje.enviarMensaje(binding.root,"Ingrese nombre y apellidos",TipoMensaje.ERROR)
        }else if (!validarEmail()){
            AppMensaje.enviarMensaje(binding.root,"Ingrese el email",TipoMensaje.ERROR)
        }else if (!validarPassword()){
            AppMensaje.enviarMensaje(binding.root,"Ingrese la contraseña",TipoMensaje.ERROR)
        }else if (!validarGenero()){
            AppMensaje.enviarMensaje(binding.root,"Seleccione su Sexo",TipoMensaje.ERROR)
        }else if (!validarPreferencias()){
            AppMensaje.enviarMensaje(binding.root,"Seleccione un hobby",TipoMensaje.ERROR)
        }else if (!validarHobbie()){
            AppMensaje.enviarMensaje(binding.root,"Ingrese un hobby adicional",TipoMensaje.ERROR)
        }else{
            rpta = true
        }
        return  rpta
    }

//--------------------------VALIDACIONES------------------------------

    private fun validarDni(): Boolean {
        var rpta = true
        if (binding.etdni.text.trim().isEmpty() || binding.etdni.length() != 8){
            binding.etdni.isFocusableInTouchMode = true
            binding.etdni.requestFocus()
            rpta = false

        }
        return  rpta
    }

    private fun validarNombreApellido(): Boolean {
        var rpta = true
        if (binding.etnombre.text.trim().isEmpty()){
            binding.etnombre.isFocusableInTouchMode = true
            binding.etnombre.requestFocus()
            rpta = false

        }else if(binding.etapellido.text.trim().isEmpty()){
            binding.etapellido.isFocusableInTouchMode = true
            binding.etapellido.requestFocus()
            rpta = false
        }
        return  rpta
    }

    private fun validarEmail(): Boolean {
        var rpta = true
        if (binding.etemail.text.trim().isEmpty()){
            binding.etemail.isFocusableInTouchMode = true
            binding.etemail.requestFocus()
            rpta = false
        }
        return  rpta
    }

    private fun validarPassword(): Boolean {
        var rpta = true
        if (binding.etpassword.text.trim().isEmpty()){
            binding.etpassword.isFocusableInTouchMode = true
            binding.etpassword.requestFocus()
            rpta = false
        }
        return  rpta
    }

    private fun validarGenero(): Boolean {
        var rpta=true
        if (binding.radioGroup.checkedRadioButtonId == -1){
            rpta = false
        }
        return rpta
    }

    private fun validarPreferencias(): Boolean {
        var rpta = false
        if (binding.chkdeporte.isChecked|| binding.chkpintura.isChecked|| binding.chkotro.isChecked){
            rpta = true
        }
        return  rpta
    }

    private fun validarHobbie(): Boolean {
        var rpta= true
        if (binding.ethobby.text.trim().isEmpty()){
            binding.ethobby.isFocusableInTouchMode = true
            binding.ethobby.requestFocus()
            rpta=false
        }
        return rpta
    }

    private fun agregarQuitarPreferencias(checkBox: CheckBox) {
        if (checkBox.isChecked){
            listapreferencias.add(checkBox.text.toString())
        }else{
            listapreferencias.remove(checkBox.text.toString())
        }
    }

    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, p3: Long) {
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}