package com.example.mvp_scanner.screens.MainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl
import com.example.mvp_scanner.core.model.equipId
import com.example.mvp_scanner.domain.repository.QrRepo
import com.example.mvp_scanner.screens.MainScreen.models.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: QrRepo,
): ViewModel() {

    private val _state = MutableStateFlow(MainState())
    public val state = _state.asStateFlow()


    fun scann(navHostController: NavHostController) {
        viewModelScope.launch {
            repo.startScanning().collect{
                if (!it.isNullOrBlank()){
                    _state.value = state.value.copy(
                        requestUrl = it
                    )
                }
                equipId.id = state.value.requestUrl.split("/").last()
                navHostController.navigate(NavControl.EquipmentScreen.route+state.value.requestUrl.split("/").last())
            }
        }
    }

}