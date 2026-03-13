package com.example.userprofileconsole

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class InventoryItem(
    val name: String,
    val category: String,
    val quantity: Int
)

@Composable
fun InventoryScreen() {

    var items by remember {
        mutableStateOf(
            mutableListOf(
                InventoryItem("Laptop","Electronics",5),
                InventoryItem("Mouse","Electronics",25),
                InventoryItem("Headphones","Electronics",0),
                InventoryItem("Notebook","Stationery",100),
                InventoryItem("Pen","Stationery",200)
            )
        )
    }

    var searchText by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    var sortByStock by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    val categories = listOf("All","Electronics","Stationery")

    val filteredItems = items
        .filter {
            (selectedCategory == "All" || it.category == selectedCategory) &&
                    it.name.contains(searchText,true)
        }
        .let {
            if(sortByStock) it.sortedBy { item -> item.quantity }
            else it.sortedBy { item -> item.name }
        }

    val totalItems = items.sumOf { it.quantity }

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true }
            ) {
                Text("+")
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {

            Text(
                text = "📦 Inventory Manager",
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(modifier = Modifier.padding(16.dp)) {

                    Text("Inventory Summary")

                    Text("Total Stock: $totalItems")

                    Text("Items Count: ${items.size}")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Search Item") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row {

                categories.forEach { category ->

                    Button(
                        onClick = { selectedCategory = category },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(category)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { sortByStock = !sortByStock }
            ) {
                Text(if(sortByStock) "Sort: Stock" else "Sort: Name")
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {

                items(filteredItems) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                item.name,
                                fontSize = 20.sp
                            )

                            Text("Category: ${item.category}")

                            Text(
                                text = "Stock: ${item.quantity}",
                                color =
                                    if(item.quantity == 0) Color.Red
                                    else Color.Black
                            )

                            LinearProgressIndicator(
                                progress = item.quantity / 100f,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 6.dp)
                            )

                            if(item.quantity < 5){

                                Text(
                                    "⚠ Low Stock",
                                    color = Color.Red
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    if(showDialog){

        AddItemDialog(
            onDismiss = { showDialog = false },
            onAdd = { newItem ->

                items = (items + newItem).toMutableList()

                showDialog = false
            }
        )
    }
}

@Composable
fun AddItemDialog(
    onDismiss: () -> Unit,
    onAdd: (InventoryItem) -> Unit
){

    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }

    AlertDialog(

        onDismissRequest = onDismiss,

        confirmButton = {

            Button(

                onClick = {

                    val qty = quantity.toIntOrNull() ?: 0

                    onAdd(
                        InventoryItem(name,category,qty)
                    )
                }

            ) {

                Text("Add")
            }
        },

        dismissButton = {

            Button(onClick = onDismiss){

                Text("Cancel")
            }
        },

        title = {

            Text("Add Item")
        },

        text = {

            Column {

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Item Name") }
                )

                OutlinedTextField(
                    value = category,
                    onValueChange = { category = it },
                    label = { Text("Category") }
                )

                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = { Text("Quantity") }
                )
            }
        }
    )
}