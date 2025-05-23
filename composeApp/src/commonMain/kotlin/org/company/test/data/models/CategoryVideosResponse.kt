package org.company.test.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryVideosResponse(
    @SerialName("categoryvideos")
    val categoryvideos: List<CategoryVideo>,
    @SerialName("ui")
    val ui: Ui
)