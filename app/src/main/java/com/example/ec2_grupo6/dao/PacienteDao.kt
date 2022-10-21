package com.example.ec2_grupo6.dao

import com.example.ec2_grupo6.model.Paciente

interface PacienteDao {



    fun listar():ArrayList<Paciente>

    fun crear(paciente:Paciente)
    fun tostring():ArrayList<String>

}