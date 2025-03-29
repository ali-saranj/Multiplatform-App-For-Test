package org.company.test.presenter.video

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.company.test.core.baseclass.BaseViewModel
import org.company.test.core.baseclass.Resource
import org.company.test.domein.repository.video.model.Video
import org.company.test.domein.usecase.GetVideoUseCase

class VideoViewModel(val getVideoUseCase: GetVideoUseCase) :
    BaseViewModel<VideoScreenState, VideoScreenEvent, VideoScreenEffect>(
        initialState = VideoScreenState(),
        reducer = VideoScreenReducer()
    ) {

    init {
        getVideo()
    }

    fun getVideo() = viewModelScope.launch(Dispatchers.IO) {
        getVideoUseCase(Unit).collect { response ->
            when (response) {
                is Resource.Error -> {
                    sendEvent(VideoScreenEvent.Error(response.message))
                }

                Resource.Loading -> {
                    sendEvent(VideoScreenEvent.Loading(true))
                }

                is Resource.Success<List<Video>> -> {
                    sendEvent(VideoScreenEvent.GetVideo(response.data))
                }
            }
        }
    }
}