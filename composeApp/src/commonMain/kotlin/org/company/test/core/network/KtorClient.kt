package org.company.test.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.client.request.accept
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.OutgoingContent
import io.ktor.http.content.TextContent
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.http.withCharset
import io.ktor.serialization.ContentConverter
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.reflect.TypeInfo
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.charsets.Charset
import io.ktor.utils.io.core.readText
import io.ktor.utils.io.readRemaining
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializerOrNull
import org.company.test.data.models.CategoryVideosResponse

expect fun getHttpEngine(): HttpClientEngine

class HttpExceptions(
    response: HttpResponse,
    failureReason: String?,
    cachedResponseText: String,
) : ResponseException(response, cachedResponseText) {
    override val message: String = "Status: ${response.status}." + " Failure: $failureReason"
}

class ApiClient {

    class TextAsJsonConverter(private val json: Json) : ContentConverter {

        override suspend fun serialize(
            contentType: ContentType,
            charset: Charset,
            typeInfo: TypeInfo,
            value: Any?
        ): OutgoingContent? {
            if (value == null) return null
            val serializer = json.serializersModule.serializerOrNull(typeInfo.kotlinType!!)
                ?: throw SerializationException("Serializer for ${typeInfo.type} not found")
            val jsonString = json.encodeToString(serializer as KSerializer<Any>, value)
            return TextContent(jsonString, contentType.withCharset(charset))
        }

        override suspend fun deserialize(
            charset: Charset,
            typeInfo: TypeInfo,
            content: ByteReadChannel
        ): Any? {
            val text = content.readRemaining().readText(charset)
            val serializer = json.serializersModule.serializerOrNull(typeInfo.kotlinType!!)
                ?: throw SerializationException("Serializer for ${typeInfo.type} not found")
            return json.decodeFromString(serializer as KSerializer<*>, text)
        }
    }

    val client = HttpClient(getHttpEngine()) {

        install(ContentNegotiation) {
            register(ContentType.Text.Plain, TextAsJsonConverter(Json {
                ignoreUnknownKeys = true
                isLenient = true
                prettyPrint = true
            }))
        }

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    co.touchlab.kermit.Logger.w("NetWork") { message }
                }
            }
        }

//        install(HttpTimeout) {
//            requestTimeoutMillis = 5000
//            connectTimeoutMillis = 10000
//            socketTimeoutMillis = 15000
//        }
        install(DefaultRequest) {
            headers.append(HttpHeaders.Accept, "application/json, text/plain")
            contentType(ContentType.Application.Json)
        }
    }
}
