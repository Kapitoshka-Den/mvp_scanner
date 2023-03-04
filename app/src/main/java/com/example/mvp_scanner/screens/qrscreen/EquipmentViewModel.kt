package com.example.mvp_scanner.screens.qrscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvp_scanner.core.model.StaticToken
import com.example.mvp_scanner.core.model.equipId
import com.example.mvp_scanner.domain.apimodels.EquipmentApi
import com.example.mvp_scanner.domain.models.Equipment
import com.example.mvp_scanner.domain.repository.DataStoreRepo
import com.example.mvp_scanner.domain.repository.QrRepo
import com.example.mvp_scanner.screens.qrscreen.model.EquipmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.auth.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipmentViewModel @Inject constructor(
    private val qrRepo: QrRepo,
    client: HttpClient,
    dataStoreRepo: DataStoreRepo
) :
    ViewModel() {

    private val _state = MutableStateFlow(EquipmentState());
    public val state = _state.asStateFlow()

    private val _token = MutableStateFlow(String())
    public val token = _token.asStateFlow()

    val _equipId = MutableStateFlow(String())

    fun changeId(id: String) {
        _equipId.value = id;
    }

    init {
        viewModelScope.launch {
            Log.e("error", StaticToken.token)
            val test = client.use { client ->
                client.get(URL_EQUIPMENT_GET + equipId.id) {
                    headers {
                        append(HttpHeaders.Authorization, "Bearer ${StaticToken.token}")
                    }
                }
            }.body<EquipmentApi>()
            Log.e("error", "endget")
            _state.value = state.value.copy(
                title = test.title,
                model = test.model,
                description = test.description,
                purchaseDate = test.purchaseDate,
                type = test.type.name,
                bindTitle = test.binder.audience.technicalTask ?: test.binder.user.jobTitle ?: ""
            )
        }
    }


    companion object {
        const val URL_EQUIPMENT_GET = "http://banaworld.ru:5003/Equipment/Api/Equipment/"
    }
}