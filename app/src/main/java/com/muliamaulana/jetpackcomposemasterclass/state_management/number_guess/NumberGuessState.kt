package com.muliamaulana.jetpackcomposemasterclass.state_management.number_guess

/**
 * Created by muliamaulana on 23/12/24.
 */
data class NumberGuessState(
    val numberText: String = "",
    val guessText: String? = null,
    val isGuessCorrect: Boolean = false
)
