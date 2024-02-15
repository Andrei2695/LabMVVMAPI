package com.a3c.labmvvmapi.data.network

import com.a3c.labmvvmapi.data.network.model.User
import retrofit2.http.GET

//AAC Paso 3 creacion del api con el edpoint del api que vamos a obtener con los datos
interface ApiService {
	@GET("users")
	suspend fun getUsers(): List<User>
	
}