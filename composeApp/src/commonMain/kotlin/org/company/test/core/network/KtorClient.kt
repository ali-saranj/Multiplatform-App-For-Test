package org.company.test.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

expect fun getHttpEngine(): HttpClientEngine

class ApiClient {

    val client = HttpClient(getHttpEngine()) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true  // نادیده گرفتن فیلدهای اضافی در پاسخ
                isLenient = true          // انعطاف‌پذیری در خواندن JSON
                prettyPrint = true        // خواناتر کردن JSON در لاگ‌ها
            })
        }

        install(Logging) {
            level = LogLevel.ALL  // نمایش همه‌ی لاگ‌های شبکه
            logger = object : Logger {
                override fun log(message: String) {
                    co.touchlab.kermit.Logger.w("NetWork") { message }
                }
            }

        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15000
            connectTimeoutMillis = 10000
            socketTimeoutMillis = 15000
        }

        install(DefaultRequest) {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }
}