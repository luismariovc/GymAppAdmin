package com.example.gymappadmin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.gymappadmin.databinding.FragmentLoginBinding
import com.example.gymappadmin.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoginViewModel.LoginState.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.btnLogin.isEnabled = false
                }
                is LoginViewModel.LoginState.Success -> {
                    binding.progressBar.isVisible = false
                    binding.btnLogin.isEnabled = true
                    Toast.makeText(context, "Welcome ${state.user.username}", Toast.LENGTH_SHORT).show()
                    // Navigate to next screen
                }
                is LoginViewModel.LoginState.Error -> {
                    binding.progressBar.isVisible = false
                    binding.btnLogin.isEnabled = true
                    Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
