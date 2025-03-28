package org.company.test.core.network

import io.ktor.client.engine.okhttp.OkHttp

actual fun getHttpEngine() = OkHttp.create()

