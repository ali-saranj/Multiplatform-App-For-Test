package org.company.test.domein.repository.video

import kotlinx.coroutines.flow.Flow
import org.company.test.core.baseclass.Resource
import org.company.test.domein.repository.video.model.Video

interface VideoRepository {
    suspend fun getVideoByCategory(): Flow<Resource<List<Video>>>
}