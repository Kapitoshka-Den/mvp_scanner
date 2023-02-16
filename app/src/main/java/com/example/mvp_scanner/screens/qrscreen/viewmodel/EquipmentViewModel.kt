package com.example.mvp_scanner.screens.qrscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvp_scanner.domain.repo.QrRepo
import com.example.mvp_scanner.screens.qrscreen.Model.EquipState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipmentViewModel @Inject constructor(private val qrRepo: QrRepo):ViewModel(){

    private val _state = MutableStateFlow(EquipState());
    public val state = _state.asStateFlow()


    fun startScanning(){
        viewModelScope.launch {
            qrRepo.startScanning().collect{
                if (!it.isNullOrBlank()){
                    _state.value = state.value.copy(
                        details = it
                    )
                }
            }
        }
    }
}