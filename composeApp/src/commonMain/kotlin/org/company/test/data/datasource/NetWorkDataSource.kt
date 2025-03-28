package org.company.test.data.datasource

import org.company.test.core.network.NetworkResult
import org.company.test.data.models.CategoryVideosResponse

interface NetWorkDataSource {
    suspend fun getCategoryVideos(): NetworkResult<CategoryVideosResponse>
}