package org.company.test.core.mapper

import org.company.test.data.models.CategoryVideo
import org.company.test.domein.home.model.Video

fun CategoryVideo.toVideo(): Video {
    return Video(
        id = id,
        title = title,
        description = null,
        url = frame,
        thumbnailUrl = bigPoster,
        duration = duration,
        views = visitCnt,
        likes = null,
        dislikes = null
    )
}