package com.a3c.labmvvmapi.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a3c.labmvvmapi.data.network.RetrofitInstance
import com.a3c.labmvvmapi.data.network.model.User
import kotlinx.coroutines.launch

//AAC Paso 5 Se crea el modelo que consume  el metodo del api y se devuelve la lista de Usuarios
class UserViewModel: ViewModel() {
	private val apiService = RetrofitInstance.api
	val users: MutableState<List<User>> = mutableStateOf(emptyList())
	fun getUsers() {
		viewModelScope.launch {
			try {
				val response = apiService.getUsers()
				if (response.isNotEmpty()) {
					users.value = response
				}
			} catch (e: Exception) {
			}
		}
	}
}