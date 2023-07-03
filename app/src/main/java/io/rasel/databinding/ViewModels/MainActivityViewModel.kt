package io.rasel.databinding.ViewModels

import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    private var count = 0;

    fun getCount():Int{
        return count
    }
    fun updateCount():Int{
        return ++count
    }
}