package com.designlife.aislefeature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.designlife.aislefeature.home.domain.repository.NotesRepository

class HomeViewModelFactory(
    private val notesRepository: NotesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(notesRepository) as T
    }
}