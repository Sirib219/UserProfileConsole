data class UserProfile(
    val name: String,
    val age: Int,
    val email: String,
    val showAvatar: Boolean
)

fun displayProfile(user: UserProfile) {

    if (user.showAvatar) {
        println("+-------------+")
        println("|   (•‿•)     |")
        println("+-------------+")
    }

    println("Name  : ${user.name}")
    println("Age   : ${user.age}")
    println("Email : ${user.email}")
    println("----------------------------")
}

fun main() {

    val users = listOf(
        UserProfile("Siri", 21, "siri@email.com", true),
        UserProfile("Rahul", 22, "rahul@email.com", false),
        UserProfile("Anita", 20, "anita@email.com", true)
    )

    for (user in users) {
        displayProfile(user)
    }
}

main()