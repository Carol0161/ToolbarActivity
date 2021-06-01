package com.example.toolbaractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class BienvenidoActivity : AppCompatActivity() {

   private var texto: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        texto = findViewById(R.id.textob)

        // obteniendo todos los parametros
        val bundle = intent.extras
        val dato = bundle?.getString("b")
        Log.d("tag","myValue"+dato)


        var atributo: String? = intent!!.getStringExtra("a")
        var textodefinitivo:String = atributo + texto!!.text
        texto!!.setText( textodefinitivo)

    }

}