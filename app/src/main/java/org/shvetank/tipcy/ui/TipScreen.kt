package org.shvetank.tipcy.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TipScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .weight(0.35f)
        ) {
            Text(
                text = "Tip Calculator",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.65f)
        ) {
            TipContainer()
        }
    }
}

@Composable
fun TipContainer(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var amount by remember { mutableStateOf("") }
        var tip by remember { mutableStateOf("") }
        var isChecked by remember { mutableStateOf(false) }
        var result by remember { mutableDoubleStateOf(0.0) }

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = {
                Text("Total Amount")
            }
        )
        Spacer(modifier.height(32.dp))
        OutlinedTextField(
            value = tip,
            onValueChange = { tip = it },
            label = {
                Text("Tip Percentage")
            }
        )
        Spacer(modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Round Up?",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = !isChecked }
            )
        }
        Spacer(modifier.height(32.dp))
        Button(
            onClick = { result = (amount.toDouble() * tip.toDouble() / 100) }
        ) {
            Text("Check")
        }
        Spacer(modifier.height(64.dp))
        if (isChecked) {
            Text(
                text = "Tip is: ${result.toInt()}",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            Text(
                text = "Tip is $result",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun TipScreenPrev() {
    TipScreen()
}