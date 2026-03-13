import kotlin.random.Random

fun rollDice(): Int {
    return Random.nextInt(1, 7)
}

fun rollPair() {
    val dice1 = rollDice()
    val dice2 = rollDice()

    println("Dice 1: $dice1")
    println("Dice 2: $dice2")

    if (dice1 == dice2) {
        println("🎉 Double! Both dice show $dice1")
    }

    println("-----------------------")
}

println("🎲 Rolling the Dice!")

repeat(5) {
    rollPair()
}