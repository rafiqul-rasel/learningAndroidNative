package io.rasel.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.rasel.databinding.ViewModelFactory.MainActivityViewModelFactory
import io.rasel.databinding.ViewModels.MainActivityViewModel
import io.rasel.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize view model factory
        val initialValue = 42
        val viewModelFactory = MainActivityViewModelFactory(initialValue)
        // Initialize View Binding
        viewModel= ViewModelProvider(this,viewModelFactory)[MainActivityViewModel::class.java]
        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.text = "Click to Count Increase"
        viewModel.count.observe(this) { value ->
            binding.textView.text = value.toString()
        };
        viewModel.progressBarVisibility.observe(this, Observer { isVisible ->
            binding.progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
        })


        binding.button.setOnClickListener {
            var inputText=convertToInteger(binding.editText.text.toString())
            viewModel.updateCount(inputText).toString()
            binding.editText.setText("")
        }
    }
    fun convertToInteger(text: String): Int {
        val result = text.toIntOrNull()
        return result ?: 0
    }
}