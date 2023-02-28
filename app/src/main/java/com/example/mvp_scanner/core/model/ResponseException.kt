package com.example.mvp_scanner.core.model

import io.ktor.http.*

class ResponseException(
    val code: HttpStatusCode,
    message: String
):Throwable(message)
