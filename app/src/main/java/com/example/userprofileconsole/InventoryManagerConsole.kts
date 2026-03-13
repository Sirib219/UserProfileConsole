data class Item(
    val name: String,
    val category: String,
    val price: Double,
    val stock: Int
)

println("📦 Inventory Management System")
println("-----------------------------")

val items = listOf(
    Item("Laptop", "Electronics", 70000.0, 5),
    Item("Mouse", "Electronics", 500.0, 25),
    Item("Notebook", "Stationery", 50.0, 100),
    Item("Pen", "Stationery", 20.0, 200),
    Item("Headphones", "Electronics", 2000.0, 8)
)

println("\nItems with Low Stock (<10):")

val lowStock = items.filter { it.stock < 10 }

lowStock.forEach {
    println("${it.name} - Stock: ${it.stock}")
}

println("\nCategory Totals:")

val categoryTotals = items.groupBy { it.category }

categoryTotals.forEach { (category, itemList) ->

    val totalValue = itemList.sumOf { it.price * it.stock }

    println("$category Total Value: ₹$totalValue")
}