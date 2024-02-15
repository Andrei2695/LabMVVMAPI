package com.a3c.labmvvmapi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.a3c.labmvvmapi.data.network.model.User

//AAC Paso 6 se crean la lis y el card que muestra los usuarios.
@Composable
fun UserList(viewModel: UserViewModel) {
	val posts by remember(viewModel.users) { viewModel.users }
	LaunchedEffect(Unit) {
		viewModel.getUsers()
	}
	LazyColumn {
		items(posts) { post ->
			Spacer(modifier = Modifier.size(16.dp))
			UserCard(post)
		}
	}
}

@Composable
fun UserCard(user: User) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.wrapContentHeight()
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(all = 16.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Spacer(modifier = Modifier.width(16.dp))
			Column(modifier = Modifier.fillMaxWidth()) {
				Text(text = user.name, style = typography.headlineSmall)
				Spacer(modifier = Modifier.height(4.dp))
				Text(
					text = user.username,
					style = typography.bodyMedium,
					maxLines = 1,
					overflow = TextOverflow.Ellipsis
				)
			}
		}
	}
}