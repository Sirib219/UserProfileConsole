class ProductManager {

    fun applyDiscount(
        products: List<Product>,
        discountFunction: (Double) -> Double
    ): List<Product> {

        return products.map {

            val newPrice = discountFunction(it.price)

            Product(it.name,newPrice,it.category)
        }
    }
}

data class Product(
    val name: String,
    val price: Double,
    val category: String
)

println("⚡ Lambda Discount Example")

val products = listOf(
    Product("Laptop",70000.0,"Electronics"),
    Product("Headphones",2000.0,"Electronics"),
    Product("Notebook",50.0,"Stationery")
)

val manager = ProductManager()

val discounted = manager.applyDiscount(products) { price ->

    price * 0.8
}

discounted.forEach {

    println("${it.name} | ₹${it.price}")
}