data class Contact(
    val name: String,
    val phone: String?,
    val email: String?,
    val favorite: Boolean
)

fun showContacts(title: String, contacts: List<Contact>) {
    println("\n$title")
    println("-----------------------")

    contacts.forEach {
        println("Name : ${it.name}")
        println("Phone: ${it.phone ?: "Not Available"}")
        println("Email: ${it.email ?: "Not Available"}")
        println("Favorite: ${it.favorite}")
        println("-----------------------")
    }
}

val contacts = listOf(
    Contact("Siri", "9876543210", "siri@email.com", true),
    Contact("Rahul", null, "rahul@email.com", false),
    Contact("Anita", "9998887777", null, true)
)

showContacts("All Contacts", contacts)

// Higher-order function filtering
val favoriteContacts = contacts.filter { it.favorite }

showContacts("Favorite Contacts", favoriteContacts)

// Contacts with email
val emailContacts = contacts.filter { it.email != null }

showContacts("Contacts With Email", emailContacts)