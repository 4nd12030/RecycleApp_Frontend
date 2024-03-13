package com.seminariomanufacturadigital.recycleapp.activities.administrativo.home


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.seminariomanufacturadigital.recycleapp.R
import com.seminariomanufacturadigital.recycleapp.fragments.administrativo.AdministrativoEditOrdenFragment
import com.seminariomanufacturadigital.recycleapp.fragments.operario.OperarioNewOrdenFragment
import com.seminariomanufacturadigital.recycleapp.fragments.operario.OperarioProfileFragment

class AdministrativHomeActivity : AppCompatActivity() {
    private val TAG = "AdministrativoHomeActivity "

    var bottonNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administrativ_home)

        ///Abre el fragment por defecto
        openFragment(AdministrativoEditOrdenFragment())

        bottonNavigation = findViewById(R.id.bottom_navigation)
        bottonNavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item_edit_orden -> {
                    openFragment(AdministrativoEditOrdenFragment())
                    true
                }
                R.id.item_list_ordenes -> {
                    openFragment(AdministrativoEditOrdenFragment())
                    true
                }
                R.id.item_perfil -> {
                    openFragment(OperarioProfileFragment())
                    true
                }
                else -> false
            }
        }


    }

    fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



}