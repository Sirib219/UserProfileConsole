fun printLogo() {
    println("************************")
    println("*   ANDROID BUSINESS   *")
    println("************************")
}

fun printHeader(name: String, title: String) {
    println("Name : $name")
    println("Role : $title")
    println("------------------------")
}

fun printContact(phone: String, email: String, github: String) {
    println("Phone  : $phone")
    println("Email  : $email")
    println("GitHub : $github")
}

printLogo()

printHeader(
    "Siri",
    "Android Developer Student"
)

printContact(
    "+91 9876543210",
    "siri@email.com",
    "github.com/siri"
)