package com.muliamaulana.jetpackcomposemasterclass.state_management.homework_assignment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by muliamaulana on 24/12/24.
 */

class TodoListViewModel : ViewModel() {

    private val defaultTodo = Todo("", "", false)

    private val _inputState = MutableStateFlow<Todo?>(defaultTodo)
    val inputState = _inputState.asStateFlow()

    fun onActionInput(action: InputTodoAction) {
        when (action) {
            is InputTodoAction.OnTitleChange -> {
                _inputState.update {
                    it?.copy(
                        title = action.title
                    )
                }
            }

            is InputTodoAction.OnDescriptionChange -> {
                _inputState.update {
                    it?.copy(
                        description = action.description
                    )
                }
            }

            is InputTodoAction.OnSubmit -> {
                _inputState.value?.let {
                    addTodo(it)
                }
            }

        }

    }

    fun onDeleted(todo: Todo) {
        _todos.update {
            it - todo
        }
    }

    fun onChecked(todo: Todo) {
        _todos.update { list ->
            list.map { item ->
                if (item == todo) {
                    item.copy(
                        isChecked = !item.isChecked
                    )
                } else item
            }
        }
    }

    private val _todos = MutableStateFlow(listOf<Todo>())
    val todos = _todos.asStateFlow()
    fun addTodo(todo: Todo) {
        _todos.update {
            it + todo
        }
        _inputState.update { defaultTodo }
    }
}