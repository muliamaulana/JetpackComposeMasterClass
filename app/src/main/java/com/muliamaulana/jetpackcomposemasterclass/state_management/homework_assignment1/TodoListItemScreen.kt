package com.muliamaulana.jetpackcomposemasterclass.state_management.homework_assignment1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.muliamaulana.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterClassTheme

/**
 * Created by muliamaulana on 24/12/24.
 */

@Composable
fun TodoListItemScreenRoot(modifier: Modifier = Modifier) {
    val viewmodel = viewModel<TodoListViewModel>()
    val isDone by viewmodel.isDone.collectAsStateWithLifecycle()

    TodoListItemScreen(
        isDone = isDone,
        onChecked = viewmodel::onChecked,
        modifier = modifier,
    )
}

@Composable
fun TodoListItemScreen(
    isDone: Boolean,
    onChecked: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier
            .padding(18.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {

        Column(
            modifier = modifier
                .weight(1f)
        ) {
            Text(
                modifier = modifier,
                text = "Bring out the trash",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = if (isDone) TextDecoration.LineThrough else TextDecoration.None
            )
            Text(
                text = "Better do this before wife come home.",
                fontSize = 18.sp,
                textDecoration = if (isDone) TextDecoration.LineThrough else TextDecoration.None
            )
        }

        Checkbox(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            checked = isDone,
            onCheckedChange = { checked ->
                onChecked(checked)
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TodoListItemScreenPreview() {
    JetpackComposeMasterClassTheme {
        TodoListItemScreen(
            isDone = false,
            onChecked = {}
        )
    }
}