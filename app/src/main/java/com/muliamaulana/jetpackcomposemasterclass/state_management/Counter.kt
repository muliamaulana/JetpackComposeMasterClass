package com.muliamaulana.jetpackcomposemasterclass.state_management

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muliamaulana.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterClassTheme

/**
 * Created by muliamaulana on 22/12/24.
 */


@Composable
fun Counter(
    count: Int = 0,
    onCountChanged: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onCountChanged
        ) {
            Text("Count: $count")
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
fun CounterPreview() {
    JetpackComposeMasterClassTheme {
        Counter(
            count = 0,
            onCountChanged = {}
        )
    }
}