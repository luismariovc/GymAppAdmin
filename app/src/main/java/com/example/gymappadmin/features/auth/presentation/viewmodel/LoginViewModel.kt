package com.example.gymappadmin.features.auth.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymappadmin.features.auth.domain.models.UserModel

class LoginViewModel : ViewModel() {

    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> = _loginState

    fun login(username: String, password: String) {
        _loginState.value = LoginState.Loading

        // Mock login logic
        if (username.isNotEmpty() && password.length >= 4) {
             _loginState.value = LoginState.Success(UserModel(username))
        } else {
             _loginState.value = LoginState.Error("Invalid credentials")
        }
    }

    sealed class LoginState {
        object Loading : LoginState()
        data class Success(val user: UserModel) : LoginState()
        data class Error(val message: String) : LoginState()
    }
}