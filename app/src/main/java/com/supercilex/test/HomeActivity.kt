package com.supercilex.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.supercilex.test.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {
    private val controller by lazy { findNavController(R.id.content) }
    private val configuration by lazy {
        AppBarConfiguration(setOf(R.id.showcase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Playground_NoActionBar)
        super.onCreate(savedInstanceState)
        val binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(controller, configuration)
    }

    override fun onSupportNavigateUp() =
            controller.navigateUp(configuration) || super.onSupportNavigateUp()
}
