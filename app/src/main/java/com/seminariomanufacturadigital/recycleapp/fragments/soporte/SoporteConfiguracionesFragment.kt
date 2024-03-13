package com.seminariomanufacturadigital.recycleapp.fragments.soporte

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seminariomanufacturadigital.recycleapp.R

class SoporteConfiguracionesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_soporte_configuraciones, container, false)
    }

}