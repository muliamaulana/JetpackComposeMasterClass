package com.muliamaulana.jetpackcomposemasterclass.state_management.homework_assignment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muliamaulana.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterClassTheme

/**
 * Created by muliamaulana on 24/12/24.
 */

@Composable
fun TodoListItemScreen(
    todo: Todo,
    onChecked: (Boolean) -> Unit,
    onDelete: (Todo?) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {

            Column(
                modifier = modifier
                    .weight(1f)
            ) {
                Text(
                    modifier = modifier,
                    text = todo.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (todo.isChecked) TextDecoration.LineThrough else TextDecoration.None
                )
                Text(
                    text = todo.description,
                    fontSize = 18.sp,
                    textDecoration = if (todo.isChecked) TextDecoration.LineThrough else TextDecoration.None
                )
            }

            Checkbox(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                checked = todo.isChecked,
                onCheckedChange = { checked ->
                    onChecked(checked)
                }
            )

            IconButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                onClick = { onDelete(todo) }
            ) {
                Icon(
                    tint = Color.Red,
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TodoListItemScreenPreview() {
    JetpackComposeMasterClassTheme {
        TodoListItemScreen(
            todo = Todo(
                title = "Bring out the trash",
                description = "Better do this before wife come home.",
                isChecked = false
            ),
            onChecked = {},
            onDelete = {}
        )
    }
}