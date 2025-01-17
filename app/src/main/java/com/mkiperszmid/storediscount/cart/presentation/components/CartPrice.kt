package com.mkiperszmid.storediscount.cart.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CartPrice(
    title: String,
    price: Double,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$title: ", fontSize = 16.sp)
        Text(text = String.format("$%.2f", price), fontSize = 24.sp)
    }
}

@Preview
@Composable
fun CartPricePreview() {
    CartPrice(
        title = "Descuento",
        price = 100.0
    )
}
