package com.example.mvp_scanner.screens.qrscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.mvp_scanner.NavControl
import com.example.mvp_scanner.domain.repo.QrRepo
import com.example.mvp_scanner.screens.qrscreen.model.EquipState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipmentViewModel @Inject constructor(private val qrRepo: QrRepo):ViewModel(){

    private val _state = MutableStateFlow(EquipState());
    public val state = _state.asStateFlow()



}