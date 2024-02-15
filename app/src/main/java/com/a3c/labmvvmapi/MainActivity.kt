package com.a3c.labmvvmapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.a3c.labmvvmapi.ui.UserList
import com.a3c.labmvvmapi.ui.UserViewModel
import com.a3c.labmvvmapi.ui.theme.LabMVVMAPITheme

class MainActivity : ComponentActivity() {
	private val viewModel: UserViewModel by viewModels()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LabMVVMAPITheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					Box(
						modifier = Modifier
							.fillMaxSize()
							.padding(horizontal = 16.dp)
					) {
						//AAC Paso 7 Se realiza la invocación  del metodo de la vista.
					UserList(viewModel = viewModel)
				}}
			}
		}
	}
}