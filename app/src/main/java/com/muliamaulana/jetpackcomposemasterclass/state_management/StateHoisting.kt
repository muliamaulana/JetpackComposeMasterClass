package com.muliamaulana.jetpackcomposemasterclass.state_management

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muliamaulana.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterClassTheme

/**
 * Created by muliamaulana on 22/12/24.
 */

@Composable
fun StateHoistingDemo(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Counter(
            count = count,
            onCountChanged = {
                count++
            }
        )
        Button(
            onClick = {
                count = 0
            }
        ) {
            Text(text = "Reset")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun StateHoistingDemoPreview() {
    JetpackComposeMasterClassTheme {
        StateHoistingDemo()
    }
}