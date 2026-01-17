package com.example.gymappadmin.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.gymappadmin.databinding.ActivityLoginBinding
import com.example.gymappadmin.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
        observeViewModel()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.login(username, password)
        }
    }

    private fun observeViewModel() {
        viewModel.loginState.observe(this) { state ->
            when (state) {
                is LoginViewModel.LoginState.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.btnLogin.isEnabled = false
                }
                is LoginViewModel.LoginState.Success -> {
                    binding.progressBar.isVisible = false
                    binding.btnLogin.isEnabled = true
                    Toast.makeText(this, "Welcome ${state.user.username}", Toast.LENGTH_SHORT).show()
                    // Navigate to next screen
                }
                is LoginViewModel.LoginState.Error -> {
                    binding.progressBar.isVisible = false
                    binding.btnLogin.isEnabled = true
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
