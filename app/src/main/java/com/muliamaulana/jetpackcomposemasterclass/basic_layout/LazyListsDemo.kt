package com.muliamaulana.jetpackcomposemasterclass.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muliamaulana.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterClassTheme
import kotlin.random.Random

/**
 * Created by muliamaulana on 19/12/24.
 */

@Composable
fun LazyListDemo(modifier: Modifier = Modifier) {

    Column {

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(100) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color(Random.nextInt()))
                )
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(100) { i ->
                Text(
                    text = "Item $i",
                    modifier = if (i % 2 == 0) {
                        Modifier
                            .fillParentMaxWidth()
                            .background(Color.LightGray)
                            .padding(16.dp)
                    } else Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun LazyListDemoPreview() {
    JetpackComposeMasterClassTheme {
        LazyListDemo()
    }
}