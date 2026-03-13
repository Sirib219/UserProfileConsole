data class Product(
    val name: String,
    val price: Double,
    val category: String
)

println("🛒 Product Analyzer")
println("-------------------------")

val products = listOf(
    Product("Laptop",70000.0,"Electronics"),
    Product("Mouse",500.0,"Electronics"),
    Product("Notebook",50.0,"Stationery"),
    Product("Headphones",2000.0,"Electronics"),
    Product("Pen",20.0,"Stationery")
)

println("\nProducts with Discount (10%)")

val discountedProducts = products.map {

    val discountPrice = it.price * 0.9

    "${it.name} | Category: ${it.category} | Discounted Price: ₹$discountPrice"
}

discountedProducts.forEach { println(it) }

println("\nFiltered Products (Price > ₹1000)")

val premiumProducts = products.filter { it.price > 1000 }

premiumProducts.forEach {

    println("${it.name} | ₹${it.price}")
}