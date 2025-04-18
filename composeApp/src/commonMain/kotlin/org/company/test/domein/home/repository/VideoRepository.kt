package org.company.test.domein.home.repository

import kotlinx.coroutines.flow.Flow
import org.company.test.core.baseclass.Resource
import org.company.test.domein.home.model.Video

interface VideoRepository {
    suspend fun getVideoByCategory(): Flow<Resource<List<Video>>>
}