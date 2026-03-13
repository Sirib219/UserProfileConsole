data class Product(
    val name: String?,
    val price: Double?,
    val category: String?
)

println("🛒 Product List")

val products = listOf(
    Product("Laptop",70000.0,"Electronics"),
    Product(null,150.0,"Accessories"),
    Product("Notebook",null,null)
)

products.forEach { product ->

    val name = product.name ?: "Unknown Product"
    val price = product.price ?: 0.0
    val category = product.category ?: "General"

    println("Product: $name")
    println("Price: ₹$price")
    println("Category: $category")

    if(price > 10000){
        println("Category Type: Premium Product")
    } else {
        println("Category Type: Budget Product")
    }

    println("------------------------")
}