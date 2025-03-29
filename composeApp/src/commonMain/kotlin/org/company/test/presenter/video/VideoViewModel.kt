package org.company.test.presenter.video

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.company.test.core.baseclass.BaseViewModel
import org.company.test.core.baseclass.Resource
import org.company.test.domein.home.model.Video
import org.company.test.domein.home.usecase.GetVideoUseCase

class VideoViewModel(val getVideoUseCase: GetVideoUseCase) :
    BaseViewModel<VideoScreenState, VideoScreenEvent, VideoScreenEffect>() {


    override fun initialState(): VideoScreenState = VideoScreenState()

    override suspend fun handleEvent(event: VideoScreenEvent) {
        when (event) {
            is VideoScreenEvent.GetVideo -> getVideo()
        }
    }

    private fun getVideo() = viewModelScope.launch(Dispatchers.IO) {
        getVideoUseCase(Unit).collect { response ->
            when (response) {
                is Resource.Error -> {
                    setState { copy(isLoading = false, error = response.message) }
                }

                Resource.Loading -> {
                    setState { copy(isLoading = false) }
                }

                is Resource.Success<List<Video>> -> {
                    setState { copy(isLoading = false, videos = response.data) }
                }
            }
        }
    }

}