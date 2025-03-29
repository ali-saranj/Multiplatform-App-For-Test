package org.company.test.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.company.test.core.baseclass.Resource
import org.company.test.core.baseclass.Resource.*
import org.company.test.core.mapper.toVideo
import org.company.test.core.network.NetworkResult
import org.company.test.data.datasource.NetWorkDataSource
import org.company.test.data.models.CategoryVideosResponse
import org.company.test.domein.home.repository.VideoRepository
import org.company.test.domein.home.model.Video

class VideoRepositoryImpl(val dataSource: NetWorkDataSource) : VideoRepository {
    override suspend fun getVideoByCategory(): Flow<Resource<List<Video>>> = flow {
        emit(Resource.Loading)
        when (val response = dataSource.getCategoryVideos()) {
            is NetworkResult.Error<*> -> {
                emit(Error(response.error.message ?: "aaa", response.error))
            }

            is NetworkResult.Success<CategoryVideosResponse> -> {
                emit(Success(response.data.categoryvideos.map { it.toVideo() }))
            }
        }
    }.flowOn(Dispatchers.IO)
}
