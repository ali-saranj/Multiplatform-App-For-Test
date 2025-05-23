package org.company.test.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import io.ktor.http.path
import org.company.test.core.network.ApiClient
import org.company.test.core.network.NetworkResult
import org.company.test.core.network.safeExecute
import org.company.test.core.network.toResult
import org.company.test.data.models.CategoryVideosResponse

class NetWorkDataSourceImpl(var api: HttpClient) : NetWorkDataSource {
    override suspend fun getCategoryVideos(): NetworkResult<CategoryVideosResponse> =
        safeExecute {
            api.get(urlString = "https://www.aparat.com/etc/api/categoryVideos/cat/7/perpage/100")
                .toResult()
        }

}