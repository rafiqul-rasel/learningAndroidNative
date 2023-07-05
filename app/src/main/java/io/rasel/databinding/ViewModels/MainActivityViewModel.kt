package io.rasel.databinding.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class MainActivityViewModel(private val initialValue: Int):ViewModel() {
    private val _progressBarVisibility = MutableLiveData<Boolean>()
    val progressBarVisibility: LiveData<Boolean> = _progressBarVisibility

    val count: MutableLiveData<Int> = MutableLiveData()


    init {
        count.value = initialValue;
        _progressBarVisibility.value = false
    }

    fun updateCount(newValue: Int) {
        _progressBarVisibility.value = true // Set loading state to true before starting the data loading

        // Perform the time-consuming operation asynchronously
        viewModelScope.launch {
            delay(5000) // Simulate a 5-second delay

            val currentCount = count.value ?: 0
            count.value = currentCount + newValue

            _progressBarVisibility.value = false // Set loading state to false after the data loading
        }
    }
}