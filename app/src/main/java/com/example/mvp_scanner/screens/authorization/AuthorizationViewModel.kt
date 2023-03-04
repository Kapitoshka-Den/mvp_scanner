package com.example.mvp_scanner.screens.authorization

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl
import com.example.mvp_scanner.core.model.StaticNavContolller
import com.example.mvp_scanner.core.model.StaticToken
import com.example.mvp_scanner.data.respository.TokensRepositoryImpl
import com.example.mvp_scanner.domain.models.AuthUser
import com.example.mvp_scanner.domain.repository.DataStoreRepo
import com.example.mvp_scanner.domain.repository.TokensRepository
import com.example.mvp_scanner.screens.authorization.models.AuthorizationState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val tokensRepository: TokensRepository,
    private val dataStoreRepo: DataStoreRepo,
    val client: HttpClient
) :
    ViewModel() {
    private val _errorState = MutableStateFlow(AuthorizationState.errorState())
    val errorState = _errorState.asStateFlow()

    private val _authorizationState = MutableStateFlow(AuthorizationState.authorizationState())
    val authorizationState = _authorizationState.asStateFlow()


    private val token = MutableLiveData<String?>()

    init {
        viewModelScope.launch {
            token.value = dataStoreRepo.getRefreshToken()
            StaticToken.token = token.value!!;

            val tes = client.post(TokensRepositoryImpl.BASE_REFRESH_URL) {
                contentType(ContentType.Application.Json)
                setBody("\"${token.value}\"")
            }

            if (tes.status == HttpStatusCode.OK) {
                StaticNavContolller.navHostController!!.navigate(NavControl.MainScreen.route) {
                    popUpTo(NavControl.AuthorizationScreen.route) {
                        inclusive = true
                    }
                }
            }
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
            if (tes!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!.code == HttpStatusCode.OK) {
                navHostController.navigate(NavControl.MainScreen.route) {
                    popUpTo(NavControl.AuthorizationScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
    }

    fun authorizeClick(navHostController: NavHostController) {
        val user = AuthUser(
            email = _authorizationState.value.login,
            password = _authorizationState.value.password,
        )
        viewModelScope.launch {
            val exception = tokensRepository.authorization(
                user
            )
            Log.e("test", exception?.message.toString())
            if (exception == null) {
                navHostController.navigate(NavControl.MainScreen.route) {
                    popUpTo(NavControl.AuthorizationScreen.route) {
                        inclusive = true
                    }
                }
            } else {
                _errorState.value = errorState.value.copy(
                    isError = true,
                    errorMessage = exception.message.toString()
                )
            }
        }
    }
}