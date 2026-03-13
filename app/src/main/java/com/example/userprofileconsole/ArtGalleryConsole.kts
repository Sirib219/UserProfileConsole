data class Artwork(
    val title: String,
    val artist: String,
    val year: Int
)

fun showArtwork(art: Artwork) {
    println("🎨 ${art.title}")
    println("Artist: ${art.artist}")
    println("Year: ${art.year}")
    println("-------------------------")
}

fun main() {

    val gallery = listOf(
        Artwork("Starry Night", "Vincent van Gogh", 1889),
        Artwork("Mona Lisa", "Leonardo da Vinci", 1503),
        Artwork("The Scream", "Edvard Munch", 1893),
        Artwork("Girl with a Pearl Earring", "Johannes Vermeer", 1665)
    )

    var index = 0

    println("🖼 Art Gallery Navigator")
    println("-------------------------")

    repeat(6) {

        showArtwork(gallery[index])

        println("Next Artwork →")

        index++

        if (index >= gallery.size) {
            index = 0
        }
    }
}