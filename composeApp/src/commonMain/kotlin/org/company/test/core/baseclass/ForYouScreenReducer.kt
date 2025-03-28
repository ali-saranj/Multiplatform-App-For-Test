package org.company.test.core.baseclass

import androidx.compose.runtime.Immutable

@Immutable
data class ForYouState(
    val topicsLoading: Boolean, // Whether the topics section is in the loading state
    val newsLoading: Boolean, // Whether the news section is in the loading state
    val topicsVisible: Boolean, // Whether the topics section is visible
) : Reducer.ViewState

@Immutable
sealed class ForYouEvent : Reducer.ViewEvent {
    data class UpdateTopicsLoading(val isLoading: Boolean) : ForYouEvent()
    data class UpdateNewsLoading(val isLoading: Boolean) : ForYouEvent()
    data class UpdateTopicsVisible(val isVisible: Boolean) : ForYouEvent()
    data class UpdateTopicIsFollowed(val topicId: String, val isFollowed: Boolean) : ForYouEvent()
    data class UpdateNewsIsSaved(val newsId: String, val isSaved: Boolean) : ForYouEvent()
    data class UpdateNewsIsViewed(val newsId: String, val isViewed: Boolean) : ForYouEvent()
}

@Immutable
sealed class ForYouEffect : Reducer.ViewEffect {
    data class NavigateToTopic(val topicId: String) : ForYouEffect()
    data class NavigateToNews(val newsUrl: String) : ForYouEffect()
}

class ForYouScreenReducer : Reducer<ForYouState, ForYouEvent, ForYouEffect> {
    override fun reduce(
        previousState: ForYouState,
        event: ForYouEvent
    ): Pair<ForYouState, ForYouEffect?> {
        return when (event) {
            // An Event that has NO associated Effect
            is ForYouEvent.UpdateTopicsLoading -> {
                previousState.copy(
                    topicsLoading = event.isLoading
                ) to null
            }

            // An Event that has an associated Effect
            is ForYouEvent.UpdateNewsIsViewed -> {
                previousState.copy(
                    topicsLoading = event.isViewed
                ) to null
            }

            is ForYouEvent.UpdateNewsIsSaved -> {
                previousState.copy(
                    topicsLoading = event.isSaved
                ) to null
            }

            is ForYouEvent.UpdateNewsLoading -> {
                previousState.copy(
                    topicsLoading = event.isLoading
                ) to null
            }

            is ForYouEvent.UpdateTopicIsFollowed -> {
                previousState.copy(
                    topicsLoading = event.isFollowed
                ) to null
            }

            is ForYouEvent.UpdateTopicsVisible -> {
                previousState.copy(
                    topicsLoading = event.isVisible
                ) to ForYouEffect.NavigateToNews("")
            }
        }
    }
}