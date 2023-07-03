package io.rasel.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import io.rasel.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.text = "Show"
        binding.progressBar.visibility= View.GONE
        binding.button.setOnClickListener {
           if(binding.progressBar.visibility== View.GONE) {
               binding.button.text = "Hide"
               binding.progressBar.visibility= View.VISIBLE
           }else{
               binding.button.text = "Show"
               binding.progressBar.visibility= View.GONE
           }
        }
    }
}