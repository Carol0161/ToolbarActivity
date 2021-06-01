package com.example.toolbaractivity.fragments.transiciones

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.toolbaractivity.R


class PrimerTransicionFragment : Fragment() {

    private var dato:String?= null
    private var campoTexto:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val  view =inflater.inflate(R.layout.fragment_primer_transicion, container, false)
        campoTexto = view.findViewById(R.id.txtNombre)

        return view

    }

    public fun getDato(): String? {
        return campoTexto!!.text.toString()
    }

    public fun getDatoFromActivity(): String? {
        val btnLogin: Button = activity!!.findViewById(R.id.btnLogin)
       // activity!!.finish()
        return btnLogin!!.text.toString()
    }


}