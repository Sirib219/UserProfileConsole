package com.example.userprofileconsole

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.ceil

@Composable
fun TipCalculatorScreen() {

    var amount by remember { mutableDoubleStateOf(0.0) }
    var tipPercent by remember { mutableIntStateOf(10) }
    var roundUp by remember { mutableStateOf(false) }

    val tip = calculateTip(amount, tipPercent, roundUp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("💰 Tip Calculator", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = amount.toString(),
            onValueChange = { amount = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Bill Amount") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Tip Percentage: $tipPercent%")

        Slider(
            value = tipPercent.toFloat(),
            onValueChange = { tipPercent = it.toInt() },
            valueRange = 0f..30f
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Round Up Tip")
            Switch(
                checked = roundUp,
                onCheckedChange = { roundUp = it }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Tip Amount: ₹$tip", fontSize = 20.sp)
    }
}

fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double {

    var tip = amount * tipPercent / 100

    if (roundUp) {
        tip = ceil(tip)
    }

    return tip
}