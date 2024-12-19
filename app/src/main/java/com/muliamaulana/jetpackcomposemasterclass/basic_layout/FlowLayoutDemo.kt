package com.muliamaulana.jetpackcomposemasterclass.basic_layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muliamaulana.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterClassTheme

/**
 * Created by muliamaulana on 19/12/24.
 */


private const val numberMaxLines = 6

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemo(
    modifier: Modifier = Modifier
) {


    var maxLines by remember { mutableIntStateOf(numberMaxLines) }

    FlowRow(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        maxLines = maxLines,
        overflow = FlowRowOverflow.expandOrCollapseIndicator(
            expandIndicator = {
                IconButton(
                    onClick = {
                        maxLines = Int.MAX_VALUE
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand"
                    )
                }
            },
            collapseIndicator = {
                IconButton(
                    onClick = {
                        maxLines = numberMaxLines
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Collapse"
                    )
                }
            }
        )
    ) {
        for (i in 1..150) {
            AssistChip(
                modifier = Modifier.padding(horizontal = 4.dp),
                onClick = {},
                label = {
                    Text("Item $i")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowLayoutDemoPreview() {
    JetpackComposeMasterClassTheme {
        FlowLayoutDemo()
    }
}
