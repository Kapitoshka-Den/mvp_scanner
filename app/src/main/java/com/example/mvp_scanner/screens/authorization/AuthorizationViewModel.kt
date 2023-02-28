package com.example.mvp_scanner.screens.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl
import com.example.mvp_scanner.domain.repository.DataStoreRepo
import com.example.mvp_scanner.domain.repository.TokensRepository
import com.example.mvp_scanner.screens.authorization.models.AuthorizationState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(val tokensRepository: TokensRepository) : ViewModel() {
    private val _errorState = MutableStateFlow(AuthorizationState.errorState())
    val errorState = _errorState.asStateFlow()

    private val _authorizationState = MutableStateFlow(AuthorizationState.authorizationState())
    val authorizationState = _authorizationState.asStateFlow()

    fun changePassword(password: String) {
        _authorizationState.value = authorizationState.value.copy(password = password)
    }

    fun changeLogin(login: String) {
        _authorizationState.value = authorizationState.value.copy(login = login)
    }

    fun checkAuthorization(navHostController: NavHostController){
        viewModelScope.launch {
            val exception = tokensRepository.changeToken()
            if(exception == null)
                navHostController.navigate(NavControl.MainScreen.route)
        }
    }

    fun authorizeClick() {

    }
}