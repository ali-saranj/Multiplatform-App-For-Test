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