package org.company.test.presenter.video

import androidx.compose.runtime.Immutable
import org.company.test.core.baseclass.Reducer
import org.company.test.domein.home.model.Video

@Immutable
data class VideoScreenState(
    val videos: List<Video> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) : Reducer.ViewState

sealed class VideoScreenEvent() : Reducer.ViewEvent {
    data object GetVideo : VideoScreenEvent()
}

sealed class VideoScreenEffect() : Reducer.ViewEffect
