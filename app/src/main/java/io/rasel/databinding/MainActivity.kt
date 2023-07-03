package io.rasel.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import io.rasel.databinding.ViewModels.MainActivityViewModel
import io.rasel.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize View Binding
        viewModel= ViewModelProvider(this)[MainActivityViewModel::class.java]
        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.text = "Click to Count Increase"
        binding.textView.text =viewModel.getCount().toString()

        binding.button.setOnClickListener {
            var inputText=binding.editText.text.toString().toInt()
            binding.textView.text =viewModel.updateCount(inputText).toString()
            binding.editText.setText("")
        }
    }
}