package com.seminariomanufacturadigital.recycleapp.providers

import com.seminariomanufacturadigital.recycleapp.api.ApiRoutes
import com.seminariomanufacturadigital.recycleapp.models.Empleado
import com.seminariomanufacturadigital.recycleapp.models.ResponseHttp
import com.seminariomanufacturadigital.recycleapp.routers.EmpleadosRoutes
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import java.io.File

//Clase 6 para conectar el backend con la app
class EmpleadosProviders(val token:String? = null) {
    private var empleadosRoutes: EmpleadosRoutes?  = null
    private var empleadosRoutesToken: EmpleadosRoutes? = null

    init {
        val api = ApiRoutes()
        empleadosRoutes = api.getEmpleadosRoutes()
        if(token!= null){
            empleadosRoutesToken = api.getEmpleadosRoutesGetToken(token!!)
        }
    }

    fun register(empleado: Empleado): Call<ResponseHttp>?{
        return empleadosRoutes?.register(empleado)
    }

    fun login(numEmpleado: String, contrasena: String): Call<ResponseHttp>? {
        return empleadosRoutes?.login(numEmpleado, contrasena)
    }

    fun update(file: File, empleado:Empleado): Call<ResponseHttp>? {
        val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
        val image = MultipartBody.Part.createFormData("image", file.name, reqFile)
        val requestBody = RequestBody.create(MediaType.parse("text/plain"), empleado.toJson())

        return empleadosRoutesToken?.update(image, requestBody, token!!)
    }

    fun updateWithoutImage(empleado:Empleado): Call<ResponseHttp>? {
        return empleadosRoutesToken?.updateWithoutImage(empleado, token!!)
    }
}