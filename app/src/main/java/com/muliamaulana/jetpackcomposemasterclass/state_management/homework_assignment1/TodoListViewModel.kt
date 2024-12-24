package com.muliamaulana.jetpackcomposemasterclass.state_management.homework_assignment1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by muliamaulana on 24/12/24.
 */

class TodoListViewModel : ViewModel() {

    private val _isDone = MutableStateFlow(false)
    val isDone = _isDone.asStateFlow()

    fun onChecked(isChecked: Boolean) {
        if (isChecked) _isDone.update { true }
        else _isDone.update { false }
    }
}