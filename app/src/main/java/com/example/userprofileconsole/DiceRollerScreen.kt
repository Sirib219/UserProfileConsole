package com.example.userprofileconsole

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun DiceRollerScreen() {

    var dice1 by remember { mutableIntStateOf(1) }
    var dice2 by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Dice Roller")

        Spacer(modifier = Modifier.height(20.dp))

        Text("Dice 1: $dice1")
        Text("Dice 2: $dice2")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                dice1 = Random.nextInt(1,7)
                dice2 = Random.nextInt(1,7)
            }
        ) {
            Text("Roll Dice")
        }

        if (dice1 == dice2) {
            Text("🎉 Double! Both dice match!")
        }
    }
}