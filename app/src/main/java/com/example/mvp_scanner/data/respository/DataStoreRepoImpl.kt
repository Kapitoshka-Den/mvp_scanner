package com.example.mvp_scanner.data.respository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.mvp_scanner.domain.models.Tokens
import com.example.mvp_scanner.domain.repository.DataStoreRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


const val TOKENS_DATASTORE = "Data_Store"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = TOKENS_DATASTORE)

class DataStoreRepoImpl @Inject constructor(val context: Context) : DataStoreRepo {

    companion object {
        val ACCES_TOKEN_KEY = stringPreferencesKey("access_token")
        val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
    }

    override suspend fun setTokens(tokens: Tokens) {
        context.dataStore.edit {
            it[ACCES_TOKEN_KEY] = tokens.accessToken
            it[REFRESH_TOKEN_KEY] = tokens.refreshToken
        }
    }

    override val getAccesToken: Flow<String> = context.dataStore.data.map { pref ->
        pref[ACCES_TOKEN_KEY] ?: ""
    }
    override suspend fun getRefreshToken(): String =
        context.dataStore.data.map{ pref ->
            pref[REFRESH_TOKEN_KEY] ?: ""
    }.first()

    override suspend fun logOut() {
        context.dataStore.edit {
            it.clear()
        }
    }

}
