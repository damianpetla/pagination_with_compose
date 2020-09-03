package com.schibsted.example.longfeedwithcompose.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LatestNewsResponse(val articles: List<List<Article>>, val links: Links)

@JsonClass(generateAdapter = true)
data class Article(
    val title: NewsTitle,
    val category: Category,
    val changes: Changes,
    @Json(name = "main_resource") val mainResource: MainResource
)

@JsonClass(generateAdapter = true)
data class MainResource(
    val type: String,
    @Json(name = "image_asset") val imageAsset: ImageAsset?,
    val caption: Caption?
)

@JsonClass(generateAdapter = true)
data class Changes(val published: String, val modified: String?)

@JsonClass(generateAdapter = true)
data class Caption(val value: String)

@JsonClass(generateAdapter = true)
data class ImageAsset(val id: String)

@JsonClass(generateAdapter = true)
data class NewsTitle(val value: String)

@JsonClass(generateAdapter = true)
data class Links(val next: String)

@JsonClass(generateAdapter = true)
data class Category(val title: String)
