package com.muliamaulana.jetpackcomposemasterclass.state_management.homework_assignment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.muliamaulana.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterClassTheme

/**
 * Created by muliamaulana on 25/12/24.
 */

@Composable
fun TodoListScreenRoot(modifier: Modifier = Modifier) {

    val viewmodel = viewModel<TodoListViewModel>()
    val inputState by viewmodel.inputState.collectAsState()
    val list by viewmodel.todos.collectAsState()

    TodoListScreen(
        modifier = modifier,
        inputState = inputState,
        list = list,
        onActionInput = viewmodel::onActionInput,
        onChecked = viewmodel::onChecked,
        onDeleted = viewmodel::onDeleted
    )
}

@Composable
fun TodoListScreen(
    modifier: Modifier = Modifier,
    inputState: Todo? = null,
    list: List<Todo> = emptyList(),
    onActionInput: (InputTodoAction) -> Unit,
    onDeleted: (Todo) -> Unit,
    onChecked: (Todo) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.TopCenter

        ) {
            if (list.isEmpty()) {
                Text(
                    text = "Nothing to do!",
                    fontWeight = FontWeight.SemiBold,
                    modifier = modifier,
                )
            } else {
                ListScreen(
                    modifier = Modifier,
                    onDeleted = onDeleted,
                    onChecked = onChecked,
                    list = list,
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = inputState?.title ?: "",
            onValueChange = { newText ->
                onActionInput(InputTodoAction.OnTitleChange(newText))
            },
            placeholder = {
                Text(
                    text = "Title",
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = inputState?.description ?: "",
            onValueChange = { newText ->
                onActionInput(InputTodoAction.OnDescriptionChange(newText))
            },
            placeholder = {
                Text(
                    text = "Description",
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onActionInput(InputTodoAction.OnSubmit)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add to do list")
        }
    }

}

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    onDeleted: (Todo) -> Unit,
    onChecked: (Todo) -> Unit,
    list: List<Todo> = emptyList()
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp) // Adds space between items
    ) {
        items(list) { item ->
            TodoListItemScreen(
                todo = item,
                onChecked = {
                    onChecked(item)
                },
                onDelete = {
                    onDeleted(item)
                }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoListScreenPreview() {
    JetpackComposeMasterClassTheme {
        var list = listOf<Todo>()
        for (i in 0..10) {
            list = list + Todo("Item $i", "Description $i", false)
        }
        TodoListScreen(
            list = list,
            onActionInput = {},
            onChecked = {},
            onDeleted = {}
        )
    }
}