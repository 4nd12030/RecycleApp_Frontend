package com.seminariomanufacturadigital.recycleapp.activities.soporte.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.seminariomanufacturadigital.recycleapp.R
import com.seminariomanufacturadigital.recycleapp.fragments.operario.OperarioNewOrdenFragment
import com.seminariomanufacturadigital.recycleapp.fragments.operario.OperarioProfileFragment
import com.seminariomanufacturadigital.recycleapp.fragments.soporte.SoporteCategoriasFragment
import com.seminariomanufacturadigital.recycleapp.fragments.soporte.SoporteConfiguracionesFragment
import com.seminariomanufacturadigital.recycleapp.fragments.soporte.SoporteOrdenesFragment
import com.seminariomanufacturadigital.recycleapp.fragments.soporte.SoporteUsuariosFragment

class SoporteHomeActivity : AppCompatActivity() {

    private  val TAG = "SoporteHomeActivity"
    var bottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soporte_home)

        ///Abre el fragment por defecto
        openFragment(SoporteOrdenesFragment())

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item_perfil ->{
                    openFragment(OperarioProfileFragment())
                    true
                }
                R.id.item_list_ordenes ->{
                    openFragment(SoporteOrdenesFragment())
                    true
                }
                R.id.item_usuarios ->{
                    openFragment(SoporteUsuariosFragment())
                    true
                }
                R.id.item_categorias ->{
                    openFragment(SoporteCategoriasFragment())
                    true
                }
                R.id.item_config ->{
                    openFragment(SoporteConfiguracionesFragment())
                    true
                }
                else -> false
            }
        }



    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}