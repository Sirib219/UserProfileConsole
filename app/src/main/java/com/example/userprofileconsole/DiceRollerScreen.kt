package com.example.userprofileconsole

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceRollerScreen() {

    var dice1 by remember { mutableIntStateOf(1) }
    var dice2 by remember { mutableIntStateOf(1) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("🎲 Dice Roller App") }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFBBDEFB)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Dice 1", fontSize = 16.sp)
                        Text(
                            text = "$dice1",
                            fontSize = 32.sp
                        )
                    }
                }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFC8E6C9)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Dice 2", fontSize = 16.sp)
                        Text(
                            text = "$dice2",
                            fontSize = 32.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    dice1 = Random.nextInt(1,7)
                    dice2 = Random.nextInt(1,7)
                },
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("Roll Dice", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (dice1 == dice2) {
                Text(
                    text = "🎉 Double! Both dice match!",
                    color = Color(0xFF2E7D32),
                    fontSize = 18.sp
                )
            }
        }
    }
}