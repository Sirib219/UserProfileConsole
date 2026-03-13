fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double {

    var tip = amount * tipPercent / 100

    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }

    return tip
}

fun main() {

    println("💰 Tip Calculator")
    println("---------------------")

    val billAmount = 500.0
    val tipPercent = 10
    val roundUp = true

    val tip = calculateTip(billAmount, tipPercent, roundUp)

    println("Bill Amount: ₹$billAmount")
    println("Tip Percent: $tipPercent%")
    println("Round Up Tip: $roundUp")
    println("Calculated Tip: ₹$tip")
}