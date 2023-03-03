package com.example.mvp_scanner.screens.authorization

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl
import com.example.mvp_scanner.core.model.ResponseException
import com.example.mvp_scanner.data.respository.TokensRepositoryImpl
import com.example.mvp_scanner.domain.models.AuthUser
import com.example.mvp_scanner.domain.models.RefreshToken
import com.example.mvp_scanner.domain.models.User
import com.example.mvp_scanner.domain.repository.DataStoreRepo
import com.example.mvp_scanner.domain.repository.TokensRepository
import com.example.mvp_scanner.screens.authorization.models.AuthorizationState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(val tokensRepository: TokensRepository,
val dataStoreRepo: DataStoreRepo,
val client: HttpClient) :
    ViewModel() {
    private val _errorState = MutableStateFlow(AuthorizationState.errorState())
    val errorState = _errorState.asStateFlow()

    private val _authorizationState = MutableStateFlow(AuthorizationState.authorizationState())
    val authorizationState = _authorizationState.asStateFlow()


    val token = MutableLiveData<String?>()
    init{
        viewModelScope.launch {
            dataStoreRepo.logOut()
        }
    }

    fun changePassword(password: String) {
        _authorizationState.value = authorizationState.value.copy(password = password)
    }

    fun changeLogin(login: String) {
        _authorizationState.value = authorizationState.value.copy(login = login)
    }

    fun checkAuthorization(navHostController: NavHostController) {
        Log.e("start", "test")
        viewModelScope.launch {
            val tes = tokensRepository.changeToken()
            if (tes!!.code == HttpStatusCode.OK){
                navHostController.navigate(NavControl.MainScreen.route) {
                    popUpTo(NavControl.AuthorizationScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
    }

    fun authorizeClick(navHostController: NavHostController) {
        viewModelScope.launch {
            val exception = tokensRepository.authorization(
                AuthUser(
                    email = _authorizationState.value.login,
                    password = _authorizationState.value.password,
                )
            )
            Log.e("test",exception?.message.toString())
            if (exception == null){
                navHostController.navigate(NavControl.MainScreen.route) {
                    popUpTo(NavControl.AuthorizationScreen.route) {
                        inclusive = true
                    }
                }
            }
            else {
                _errorState.value = errorState.value.copy(isError = true, errorMessage = exception.message.toString())
            }
        }
    }
}