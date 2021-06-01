package com.example.toolbaractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.toolbaractivity.fragments.transiciones.PrimerTransicionFragment
import com.example.toolbaractivity.fragments.transiciones.SegundoTransicionFragment

class PasoEntreFragmentsActivity : AppCompatActivity(), View.OnClickListener {

    // definicion de los elmentos que vamos a usar en la activity
    private var botonLogin: Button?=null
    private var botonRegistro: Button?=null

    var loginFragment: PrimerTransicionFragment = PrimerTransicionFragment()
    var registroFragment: SegundoTransicionFragment = SegundoTransicionFragment()

    var fragmentTransicion: FragmentTransaction = this.supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paso_entre_fragments)

        // tomamos sus valores de la parte visual
        botonLogin = findViewById(R.id.btnLogin)
        botonRegistro = findViewById(R.id.btnRegistro)

        // indicadmos que el listener de su accion de click lo lee esta clase.
        this.botonLogin!!.setOnClickListener(this)
        this.botonRegistro!!.setOnClickListener(this)

        fragmentTransicion.replace(R.id.contenedorFragments,loginFragment )
        fragmentTransicion.commit()
    }

    override fun onClick(p0: View?) {
        // gestor de fragments

        if (p0==botonLogin){
        // hacer lo que queremos que haga al dar al  primer boton
            val intento1 = Intent(this, BienvenidoActivity::class.java)
            var nombreUsu:String? = null
           nombreUsu = loginFragment!!.getDato() as String?
            intento1.putExtra("a", nombreUsu)
            intento1.putExtra("b", "carol")
            startActivity(intento1)

        }else if ( p0== botonRegistro){
            // hacer lo que queremos que haga al dar al  segundo boton
            fragmentTransicion.replace(R.id.contenedorFragments,registroFragment )
            fragmentTransicion.commit()
        }
    }
}