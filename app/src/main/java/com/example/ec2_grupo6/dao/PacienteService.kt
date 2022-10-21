package com.example.ec2_grupo6.dao

import com.example.ec2_grupo6.model.Paciente

class PacienteService: PacienteDao {

    val listapacientes = ArrayList<Paciente>()
    override fun listar(): ArrayList<Paciente> {

            return listapacientes

    }

    override fun crear(paciente: Paciente){
        listapacientes.add(paciente)
    }

    override fun tostring(): ArrayList<String> {
        var lista= ArrayList<String>()
        for (paciente in listar()){
            lista.add(paciente.nombre)
        }
        return lista
    }
}