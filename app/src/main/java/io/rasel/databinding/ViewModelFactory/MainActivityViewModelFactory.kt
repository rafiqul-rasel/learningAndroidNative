package io.rasel.databinding.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.rasel.databinding.ViewModels.MainActivityViewModel

class MainActivityViewModelFactory(val initialValue:Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(initialValue) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
