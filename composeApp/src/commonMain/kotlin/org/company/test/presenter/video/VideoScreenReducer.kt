package org.company.test.presenter.video

import androidx.compose.runtime.Immutable
import org.company.test.core.baseclass.Reducer
import org.company.test.domein.repository.video.model.Video

@Immutable
data class VideoScreenState(
    val videos: List<Video> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) : Reducer.ViewState

sealed class VideoScreenEvent() : Reducer.ViewEvent {
    data class GetVideo(val videos: List<Video>) : VideoScreenEvent()
    data class Loading(val isLoading: Boolean) : VideoScreenEvent()
    data class Error(val error: String) : VideoScreenEvent()
}

sealed class VideoScreenEffect() : Reducer.ViewEffect

class VideoScreenReducer : Reducer<VideoScreenState, VideoScreenEvent, VideoScreenEffect> {
    override fun reduce(
        previousState: VideoScreenState,
        event: VideoScreenEvent
    ): Pair<VideoScreenState, VideoScreenEffect?> {
        return when (event) {
            is VideoScreenEvent.GetVideo -> {
                previousState.copy(videos = event.videos, isLoading = false) to null
            }

            is VideoScreenEvent.Loading -> {
                previousState.copy(isLoading = event.isLoading) to null
            }

            is VideoScreenEvent.Error -> {
                previousState.copy(
                    error = event.error,
                    isLoading = false
                ) to null
            }
        }
    }
}