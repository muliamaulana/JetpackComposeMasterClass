package com.muliamaulana.jetpackcomposemasterclass.state_management.homework_assignment

/**
 * Created by muliamaulana on 25/12/24.
 */

sealed interface InputTodoAction {
    data class OnTitleChange(val title: String) : InputTodoAction
    data class OnDescriptionChange(val description: String) : InputTodoAction
    data object OnSubmit : InputTodoAction
}