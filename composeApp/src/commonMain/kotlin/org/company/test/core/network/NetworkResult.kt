package org.company.test.core.network

sealed interface NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>
    data class Error<out T : Any>(val error: Exception) : NetworkResult<T>
}

suspend fun <T : Any> safeExecute(execute: suspend () -> NetworkResult<T>): NetworkResult<T> = try {
    execute.invoke()
} catch (e: Exception) {
    NetworkResult.Error(NetworkException(e.message ?: ""))
}