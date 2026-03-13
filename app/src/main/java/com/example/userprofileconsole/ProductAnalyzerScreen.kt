package com.example.userprofileconsole

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat

data class Product(
    val name: String,
    val category: String,
    val originalPrice: Double,
    val currentPrice: Double
)

@Composable
fun ProductAnalyzerScreen() {

    val formatter = DecimalFormat("#,###.00")

    var discountPercent by remember { mutableStateOf(10f) }

    var products by remember {
        mutableStateOf(
            listOf(
                Product("Laptop","Electronics",70000.0,70000.0),
                Product("Mouse","Electronics",500.0,500.0),
                Product("Headphones","Electronics",2000.0,2000.0),
                Product("Notebook","Stationery",50.0,50.0)
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "🛒 Product Analyzer",
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Discount: ${discountPercent.toInt()}%")

        Slider(
            value = discountPercent,
            onValueChange = { discountPercent = it },
            valueRange = 0f..50f
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(products) { product ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(product.name, fontSize = 20.sp)

                        Text("Category: ${product.category}")

                        Text(
                            "Price: ₹${formatter.format(product.currentPrice)}",
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {

                            Button(
                                onClick = {

                                    val discount =
                                        product.originalPrice * (discountPercent / 100)

                                    val newPrice =
                                        product.originalPrice - discount

                                    products = products.map {

                                        if(it.name == product.name)
                                            it.copy(currentPrice = newPrice)
                                        else it
                                    }
                                }
                            ) {
                                Text("Apply Discount")
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Button(
                                onClick = {

                                    products = products.map {

                                        if(it.name == product.name)
                                            it.copy(currentPrice = it.originalPrice)
                                        else it
                                    }
                                }
                            ) {
                                Text("Reset")
                            }
                        }
                    }
                }
            }
        }
    }
}