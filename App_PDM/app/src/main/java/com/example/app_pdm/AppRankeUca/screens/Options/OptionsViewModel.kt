package com.example.app_pdm.AppRankeUca.screens.Options


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.app_pdm.AppRankeUca.data.Repository.OptionRepository
import com.example.app_pdm.AppRankeUca.data.model.Option
import com.example.app_pdm.AppPdmApplication

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
            optionRepository.addOption(Option(name = name, imageUrl = imageUrl))
        }
    }

    fun deleteOption(option: Option) {
        viewModelScope.launch {
            optionRepository.deleteOption(option)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as AppPdmApplication
                OptionsViewModel(app.appProvider.provideOptionRepository())
            }
        }
    }
}

