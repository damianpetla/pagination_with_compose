package com.schibsted.example.longfeedwithcompose

import com.schibsted.example.longfeedwithcompose.api.Article
import com.schibsted.example.longfeedwithcompose.api.LatestNewsResponse
import com.schibsted.example.longfeedwithcompose.ui.LatestData
import com.schibsted.example.longfeedwithcompose.ui.NewsItem

fun LatestNewsResponse.toData(currentArticles: List<NewsItem> = emptyList()) = LatestData(currentArticles + articles.flatten().map { it.toNewItem() } , links.next)

fun Article.toNewItem() = NewsItem(
    title.value,
    if (mainResource.type == "Image") "https://gfx-android.omni.se/images/${mainResource.imageAsset?.id}" else "",
    changes.modified ?: changes.published,
    category.title,
    if (mainResource.type == "Image") mainResource.caption?.value ?: "" else ""
)