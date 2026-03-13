data class Product(
    val name: String?,
    val price: Double?,
    val category: String?
)

val products = listOf(
    Product("Laptop",70000.0,"Electronics"),
    Product(null,150.0,"Accessories"),
    Product("Notebook",null,null)
)

products.forEach {
    val name = it.name ?: "Unknown Product"
    val price = it.price ?: 0.0
    val category = it.category ?: "General"

    println("$name - ₹$price - $category")
}