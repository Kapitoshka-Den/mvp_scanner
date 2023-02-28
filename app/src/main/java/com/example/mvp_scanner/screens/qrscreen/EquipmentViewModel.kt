package com.example.mvp_scanner.screens.qrscreen

import androidx.lifecycle.ViewModel
import com.example.mvp_scanner.domain.repository.QrRepo
import com.example.mvp_scanner.screens.qrscreen.model.EquipState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EquipmentViewModel @Inject constructor(private val qrRepo: QrRepo):ViewModel(){

    private val _state = MutableStateFlow(EquipState());
    public val state = _state.asStateFlow()



}