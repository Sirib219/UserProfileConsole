package com.example.userprofileconsole.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Product(
    val name: String,
    val category: String,
    val price: Double
)

@Composable
fun LambdaDiscountScreen() {

    var products by remember {
        mutableStateOf(
            listOf(
                Product("Laptop", "Electronics", 70000.0),
                Product("Mouse", "Electronics", 500.0),
                Product("Headphones", "Electronics", 2000.0),
                Product("Notebook", "Stationery", 50.0)
            )
        )
    }

    val originalProducts = listOf(
        Product("Laptop", "Electronics", 70000.0),
        Product("Mouse", "Electronics", 500.0),
        Product("Headphones", "Electronics", 2000.0),
        Product("Notebook", "Stationery", 50.0)
    )

    // Lambda function for discount
    val applyDiscount: (Double) -> Double = { price ->
        price * 0.9
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "💸 Lambda Discount Demo",
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {

            Button(
                onClick = {
                    products = products.map {
                        it.copy(price = applyDiscount(it.price))
                    }
                }
            ) {
                Text("Apply 10% Discount")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    products = originalProducts
                }
            ) {
                Text("Reset")
            }
        }

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

                        Text("Price: ₹${String.format("%.2f", product.price)}")
                    }
                }
            }
        }
    }
}