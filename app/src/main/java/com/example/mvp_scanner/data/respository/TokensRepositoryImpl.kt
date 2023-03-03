package com.example.mvp_scanner.data.respository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvp_scanner.core.model.ResponseException
import com.example.mvp_scanner.domain.models.AuthUser
import com.example.mvp_scanner.domain.models.User
import com.example.mvp_scanner.domain.repository.DataStoreRepo
import com.example.mvp_scanner.domain.repository.TokensRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TokensRepositoryImpl @Inject constructor(
    val client: HttpClient,
    private val dataStoreRepo: DataStoreRepo
) :
    TokensRepository {
    val token = MutableLiveData<String?>()

    override suspend fun registration(user: User): ResponseException? {
        val response = client.post("$BASE_AUTH_URL/SignUp") {
                contentType(ContentType.Application.Json)
                setBody<User>(
                    user
                )
            }
        client.close()
        if (response.status == HttpStatusCode.OK) {
            dataStoreRepo.setTokens(response.body())
            return null
        }
        if (response.status == HttpStatusCode.Unauthorized) {
            return ResponseException(HttpStatusCode.Unauthorized,"Not found account")
        }
        return ResponseException(response.status,"server exception")
    }

    override suspend fun authorization(user: AuthUser): ResponseException? {
        val response = client.use{client->
            client.post("$BASE_AUTH_URL/SignIn") {
                contentType(ContentType.Application.Json)
                setBody<AuthUser>(
                    user
                )
            }
            }
        if (response.status == HttpStatusCode.OK) {
            dataStoreRepo.setTokens(response.body())
            return null
        }
        if (response.status == HttpStatusCode.NotFound) {
            return ResponseException(HttpStatusCode.Unauthorized,"Not found account")
        }
        return ResponseException(response.status,"server exception")
    }

    override suspend fun changeToken(): ResponseException? {
        var body:String = ""
        val test = dataStoreRepo.getRefreshToken()
        val response = client.use { client ->
            token.value?.let { Log.e("next", it) }
            client.post(TokensRepositoryImpl.BASE_REFRESH_URL){
                contentType(ContentType.Application.Json)
                setBody("\"${test}\"")
            }
        }
        return if (response.status == HttpStatusCode.OK){
            ResponseException(response.status,"")
        } else{
            ResponseException(response.status,"server error")
        }
    }

    companion object {
        const val BASE_AUTH_URL = "http://banaworld.ru:5003/Auth/api/Auth"
        const val BASE_REFRESH_URL = "http://banaworld.ru:5003/Auth/api/Auth/Refresh"
    }
}
data class TestTokens(var test: String = ""){

}