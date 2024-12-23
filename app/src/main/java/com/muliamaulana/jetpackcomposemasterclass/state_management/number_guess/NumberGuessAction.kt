package com.muliamaulana.jetpackcomposemasterclass.state_management.number_guess

/**
 * Created by muliamaulana on 23/12/24.
 */

sealed interface NumberGuessAction {
    data object OnGuessClick : NumberGuessAction
    data class OnNumberTextChange(val numberText: String) : NumberGuessAction
    data object OnStartNewGameButton : NumberGuessAction
}