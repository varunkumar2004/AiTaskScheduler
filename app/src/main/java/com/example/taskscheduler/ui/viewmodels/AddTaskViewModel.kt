package com.example.taskscheduler.ui.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.sql.Timestamp
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(

) : ViewModel() {
    private val _state = MutableStateFlow(AddTaskState())
    val state = _state.asStateFlow()

    fun onTaskTitleChange(newTitle: String) {
        _state.update { it.copy(title = newTitle) }
    }

    fun onTaskDescriptionChange(newDesp: String?) {
        _state.update { it.copy(description = newDesp) }
    }
}

data class AddTaskState(
    val title: String = "",
    val description: String? = null,
)