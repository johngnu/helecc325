package com.mkiperszmid.storediscount.home.presentation

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkiperszmid.storediscount.core.presentation.StoreButton
import com.mkiperszmid.storediscount.home.presentation.components.HomeProductItem

@Composable
fun HomeScreen(
    viewmodel: HomeViewModel = hiltViewModel(),
    onCartClick: () -> Unit
) {
    val state = viewmodel.state

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    val activity = (LocalContext.current as? Activity)
    if (state.products.isNotEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                text = "Productos",
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(state.products) {
                    HomeProductItem(
                        title = it.name,
                        price = it.price,
                        modifier = Modifier.padding(16.dp),
                        onClick = {
                            viewmodel.onItemClick(it)
                        }
                    )
                }
            }
            StoreButton (
                text = "Ir al carrito",
                onClick = onCartClick,
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(16.dp)
            )
            StoreButton (
                text = "Actualizar",
                onClick = {activity?.finish()},
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        // TODO: Handle error cases
    }
}
