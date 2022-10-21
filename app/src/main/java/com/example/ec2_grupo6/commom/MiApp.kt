package com.example.ec2_grupo6.commom

import android.app.Application

class MiApp: Application() {

    companion object{
        lateinit var instance: MiApp
    }

    override fun onCreate(){
        super.onCreate()
        instance = this
    }
}