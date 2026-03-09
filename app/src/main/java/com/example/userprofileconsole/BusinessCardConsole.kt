fun printLogo() {
    println("***********************")
    println("*     ANDROID DEV     *")
    println("***********************")
}

fun printHeader(name: String, title: String) {
    println("Name : $name")
    println("Role : $title")
    println("-----------------------")
}

fun printContact(phone: String, email: String, github: String) {
    println("Phone  : $phone")
    println("Email  : $email")
    println("GitHub : $github")
}

fun main() {

    printLogo()

    printHeader(
        name = "Siri",
        title = "Android Developer Student"
    )

    printContact(
        phone = "+91 9876543210",
        email = "siri@email.com",
        github = "github.com/siri"
    )
}