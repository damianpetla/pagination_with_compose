package com.schibsted.example.longfeedwithcompose.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import com.schibsted.example.longfeedwithcompose.api.Article
import com.schibsted.example.longfeedwithcompose.api.LatestNewsResponse

fun LatestNewsResponse.toData(currentArticles: List<NewsItem> = emptyList()) =
    LatestData(currentArticles + articles.flatten().filter { it.type == "Article" }
        .map { it.toNewItem() }, links.next)

fun Article.toNewItem() = NewsItem(
    title?.value ?: "",
    if (mainResource?.type == "Image") "https://gfx-android.omni.se/images/${mainResource.imageAsset?.id}" else "",
    changes?.modified ?: changes?.published ?: "",
    category?.title ?: "",
    if (mainResource?.type == "Image") mainResource.caption?.value ?: "" else ""
)