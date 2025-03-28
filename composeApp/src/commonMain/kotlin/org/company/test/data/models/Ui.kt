package org.company.test.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ui(
    @SerialName("pagingBack")
    val pagingBack: String,
    @SerialName("pagingForward")
    val pagingForward: String
)