package com.seminariomanufacturadigital.recycleapp.routers

import com.seminariomanufacturadigital.recycleapp.models.Empleado
import com.seminariomanufacturadigital.recycleapp.models.ResponseHttp
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part

//Clase(Interface) 2 para conectar el backend con la app
interface EmpleadosRoutes {
    @POST("empleados/create") //La url que se  necesita para crear un nuevo empleado
    fun  register(@Body empleado: Empleado): Call<ResponseHttp>
    @FormUrlEncoded
    @POST("empleados/login")
    fun login(@Field("no_empleado") numEmpleadc: String,
              @Field("contrasena") contrasena:String) :Call<ResponseHttp>

    @Multipart
    @PUT("empleados/update")
    fun update(
        @Part imagen: MultipartBody.Part,
        @Part("empleado") empleado: RequestBody,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>

    @PUT("empleados/updateWithoutImage")
    fun updateWithoutImage(
        @Body empleado: Empleado,
        @Header("Authorization") token: String
    ): Call<ResponseHttp>
}