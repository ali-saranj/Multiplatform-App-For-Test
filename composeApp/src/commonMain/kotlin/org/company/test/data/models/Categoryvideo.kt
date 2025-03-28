package org.company.test.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Categoryvideo(
    @SerialName("autoplay")
    val autoplay: Boolean,
    @SerialName("big_poster")
    val bigPoster: String,
    @SerialName("create_date")
    val createDate: String,
    @SerialName("360d")
    val d: Boolean,
    @SerialName("deleteurl")
    val deleteurl: String,
    @SerialName("duration")
    val duration: Int,
    @SerialName("frame")
    val frame: String,
    @SerialName("id")
    val id: String,
    @SerialName("isHidden")
    val isHidden: Boolean,
    @SerialName("official")
    val official: String,
    @SerialName("process")
    val process: String,
    @SerialName("profilePhoto")
    val profilePhoto: String,
    @SerialName("sdate")
    val sdate: String,
    @SerialName("sdate_timediff")
    val sdateTimediff: Int,
    @SerialName("sender_name")
    val senderName: String,
    @SerialName("small_poster")
    val smallPoster: String,
    @SerialName("title")
    val title: String,
    @SerialName("uid")
    val uid: String,
    @SerialName("userid")
    val userid: String,
    @SerialName("username")
    val username: String,
    @SerialName("video_date_status")
    val videoDateStatus: String,
    @SerialName("visit_cnt")
    val visitCnt: Int
)