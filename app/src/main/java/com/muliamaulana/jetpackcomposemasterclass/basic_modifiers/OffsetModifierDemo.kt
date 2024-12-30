package com.muliamaulana.jetpackcomposemasterclass.basic_modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muliamaulana.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterClassTheme

/**
 * Created by muliamaulana on 30/12/24.
 */

@Composable
fun OffsetModifierDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .size(width = 150.dp, height = 100.dp)
            .background(Color.Red)
    ) {
        Text(
            text = "Hello World",
            modifier = Modifier
                .offset(
                    x = 55.dp,
                    y = 10.dp
                )
                .background(Color.Green)
        )

        Text(
            text = "Jetpack Compose",
            modifier = Modifier
                .background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OffsetModifierDemoPreview() {
    JetpackComposeMasterClassTheme {
        OffsetModifierDemo()
    }
}