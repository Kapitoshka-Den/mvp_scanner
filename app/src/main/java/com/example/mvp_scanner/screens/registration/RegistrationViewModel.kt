package com.example.mvp_scanner.screens.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl
import com.example.mvp_scanner.domain.models.RegUser
import com.example.mvp_scanner.domain.repository.TokensRepository
import com.example.mvp_scanner.screens.registration.models.RegistrationState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    client: HttpClient,
    private val tokensRepository: TokensRepository
) : ViewModel() {

    private val _errorState = MutableStateFlow(RegistrationState.errorState())
    val errorState = _errorState.asStateFlow()

    private val _registrationState = MutableStateFlow(RegistrationState.registrationState())
    val registrationState = _registrationState.asStateFlow()

    fun changeName(name: String) {
        _registrationState.value = registrationState.value.copy(email = name)
    }

    fun changeLogin(login: String) {
        _registrationState.value = registrationState.value.copy(login = login)
    }

    fun changePassword(password: String) {
        _registrationState.value = registrationState.value.copy(password = password)
    }

    fun regClick(navHostController: NavHostController) {
        viewModelScope.launch {
            val response = tokensRepository.registration(
                RegUser(
                    login = registrationState.value.login,
                    email = registrationState.value.email,
                    password = registrationState.value.password
                )
            )
            if(response == null){
                navHostController.navigate(NavControl.MainScreen.route){
                    popUpTo(NavControl.RegistrationScreen.route){
                        inclusive = true
                    }
                }
            }
            else{
                _errorState.value = errorState.value.copy(isError = true, errorMessage = response.code.value.toString())
            }
        }
    }
}