package org.company.test

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.company.test.domein.home.model.Video
import org.company.test.presenter.video.components.CardVideo

@Preview
@Composable
private fun CardVideoPreview() {
    CardVideo(
        video = Video(
            id = "v123",
            title = "Introduction to Kotlin Programming",
            description = "A beginner-friendly guide to Kotlin basics.",
            url = "https://example.com/videos/kotlin-intro",
            thumbnailUrl = "https://example.com/thumbnails/kotlin-intro.jpg",
            duration = 600, // 10 minutes in seconds
            views = 15000,
            likes = 1200,
            dislikes = 30
        )
    )
}