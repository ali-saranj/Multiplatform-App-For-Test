package org.company.test.domein.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.lastOrNull
import org.company.test.core.baseclass.BaseUseCase
import org.company.test.core.baseclass.Resource
import org.company.test.domein.repository.video.VideoRepository
import org.company.test.domein.repository.video.model.Video

class GetVideoUseCase(val repository: VideoRepository) :
    BaseUseCase<Unit, Flow<Resource<List<Video>>>>() {
    override suspend fun invoke(input: Unit): Flow<Resource<List<Video>>> =
        repository.getVideoByCategory()
}