package com.example.app_pdm.AppRankeUca.screens.Options

// screens/Options/OptionsViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.app_pdm.AppRankeUca.data.Repository.OptionRepository
import com.example.app_pdm.AppRankeUca.model.Option
import com.example.app_pdm.BasicTemplateApplication

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OptionsViewModel(
    private val optionRepository: OptionRepository
) : ViewModel() {

    val options: StateFlow<List<Option>> =
        optionRepository.getOptions()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addOption(name: String, imageUrl: String) {
        viewModelScope.launch {
            optionRepository.addOption(
                Option(
                    id = 0,
                    name = name,
                    imageUrl = imageUrl,
                    votes = 0
                )
            )
        }
    }

    fun deleteOption(option: Option) {
        viewModelScope.launch {
            optionRepository.deleteOption(option)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BasicTemplateApplication
                OptionsViewModel(app.appProvider.provideOptionRepository())
            }
        }
    }
}