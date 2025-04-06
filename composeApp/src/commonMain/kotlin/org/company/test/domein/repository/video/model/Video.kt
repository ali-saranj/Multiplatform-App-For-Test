package org.company.test.domein.repository.video.model

data class Video(
    val id: String,
    val title: String,
    val description: String?,
    val url: String,
    val thumbnailUrl: String,
    val duration: Int,
    val views: Int,
    val likes: Int?,
    val dislikes: Int?,
)
