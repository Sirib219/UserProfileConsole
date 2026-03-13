package com.example.userprofileconsole

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Artwork(
    val title: String,
    val artist: String,
    val year: Int,
    val description: String,
    val imageRes: Int
)

@Composable
fun ArtGalleryScreen() {

    val artworks = listOf(
        Artwork(
            "Starry Night",
            "Vincent van Gogh",
            1889,
            "A famous painting showing a swirling night sky over a small town.",
            R.drawable.starry_night
        ),
        Artwork(
            "Mona Lisa",
            "Leonardo da Vinci",
            1503,
            "One of the most famous portraits in the world.",
            R.drawable.mona_lisa
        ),
        Artwork(
            "The Scream",
            "Edvard Munch",
            1893,
            "An expressionist painting representing human anxiety.",
            R.drawable.the_scream
        ),
        Artwork(
            "Girl with a Pearl Earring",
            "Johannes Vermeer",
            1665,
            "A beautiful portrait often called the Dutch Mona Lisa.",
            R.drawable.girl_pearl
        )
    )

    var index by remember { mutableIntStateOf(0) }

    val currentArt = artworks[index]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "🖼 Art Gallery",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {

            Image(
                painter = painterResource(currentArt.imageRes),
                contentDescription = currentArt.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = currentArt.title,
            fontSize = 22.sp
        )

        Text(
            text = "Artist: ${currentArt.artist}",
            fontSize = 16.sp
        )

        Text(
            text = "Year: ${currentArt.year}",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = currentArt.description,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Button(
                onClick = {
                    index--
                    if (index < 0) index = artworks.size - 1
                },
                shape = RoundedCornerShape(50)
            ) {
                Text("⬅ Previous")
            }

            Button(
                onClick = {
                    index++
                    if (index >= artworks.size) index = 0
                },
                shape = RoundedCornerShape(50)
            ) {
                Text("Next ➡")
            }
        }
    }
}