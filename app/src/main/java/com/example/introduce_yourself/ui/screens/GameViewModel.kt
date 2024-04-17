package com.example.introduce_yourself.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    // Game UI state
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private var story : String = ""
    private var splitStory : List<String> = emptyList()
    private var currentIndx = 0

    private val foods = listOf("Boreg", "Lahmajoun", "Kabob", "Dolma")

    // -------Edit the values below with your information =)-----------

    private val name : String = "Sarah"
    private val age : Int = 25
    private val hasTraveledToArmenia : Boolean = true
    private val favoriteFood : String = foods[1]

    // ----------------------------------------------------------------

    init {
      buildStory()
    }

    private fun buildStory() {
        story = "Hello! My name is $name." +
                " I am $age years old."
        story = if (hasTraveledToArmenia) {
            "$story Yes, I have travelled to Armenia."
        } else {
            "$story No, I have not travelled to Armenia."
        }
        story = "$story My favorite Armenian food is $favoriteFood."
        splitStory = story.split(" ")
        Log.d("GameViewModel", "Story: $story")
        _uiState.update {
            it.copy(
                currentWord = splitStory[currentIndx],
                isStoryDone = false
            )
        }
    }

    fun moveOne() {
        var storyComplete = false
        if (currentIndx + 1 < splitStory.size) {
            currentIndx += 1
        } else {
            storyComplete = true
        }
        _uiState.update { currentState ->
            currentState.copy(
                currentWord = splitStory[currentIndx],
                isStoryDone = storyComplete
            )
        }
    }

    fun moveThree() {
        var storyComplete = false
        if (currentIndx + 3 < splitStory.size) {
            currentIndx += 3
        } else {
            storyComplete = true
        }
        _uiState.update { currentState ->
            currentState.copy(
                currentWord = splitStory[currentIndx],
                isStoryDone = storyComplete
            )
        }
    }

    fun backOne() {
        var storyComplete = false
        if (currentIndx - 1 >= 0) {
            currentIndx -= 1
        } else {
            storyComplete = true
        }
        _uiState.update { currentState ->
            currentState.copy(
                currentWord = splitStory[currentIndx],
                isStoryDone = storyComplete
            )
        }
    }

    fun backThree() {
        var storyComplete = false
        if (currentIndx - 3 >= 0) {
            currentIndx -= 3
        } else {
            storyComplete = true
        }
        _uiState.update { currentState ->
            currentState.copy(
                currentWord = splitStory[currentIndx],
                isStoryDone = storyComplete
            )
        }
    }
}