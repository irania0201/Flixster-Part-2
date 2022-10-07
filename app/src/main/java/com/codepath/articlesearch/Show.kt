package com.codepath.articlesearch

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchShowsResponse(
    @SerialName("results")
    val results: List<Show>
)

@Keep
@Serializable
class Show(
    @SerialName("poster_path")
    val poster: String?,
    @SerialName("backdrop_path")
    val backdrop: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("first_air_date")
    val airDate: String?,
    @SerialName("vote_average")
    val vote: String?,
    @SerialName("original_language")
    val lang: String?
) : java.io.Serializable {}