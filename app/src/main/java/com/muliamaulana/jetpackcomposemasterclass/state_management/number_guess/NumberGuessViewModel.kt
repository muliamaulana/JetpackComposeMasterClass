package com.muliamaulana.jetpackcomposemasterclass.state_management.number_guess

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

/**
 * Created by muliamaulana on 23/12/24.
 */
private const val MAX_NUMBER = 101

class NumberGuessViewModel : ViewModel() {

    private var number = Random.nextInt(0, MAX_NUMBER)
    private var attemps = 0

    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    fun onAction(action: NumberGuessAction) {
        when (action) {
            NumberGuessAction.OnGuessClick -> {
                val guess = _state.value.numberText.toIntOrNull()
                attemps++

                _state.update {
                    it.copy(
                        guessText = when {
                            guess == null -> "Please enter a number"
                            number > guess -> "Nope, my number is larger"
                            number < guess -> "Nope, my number is smaller"
                            else -> "That was it! You got it in $attemps attempts"
                        },
                        isGuessCorrect = guess == number,
                        numberText = ""
                    )
                }
            }

            is NumberGuessAction.OnNumberTextChange -> {
                _state.update {
                    it.copy(
                        numberText = action.numberText
                    )
                }
            }

            NumberGuessAction.OnStartNewGameButton -> {
                number = Random.nextInt(1, MAX_NUMBER)
                _state.update {
                    it.copy(
                        numberText = "",
                        guessText = null,
                        isGuessCorrect = false
                    )
                }
            }
        }
    }

}