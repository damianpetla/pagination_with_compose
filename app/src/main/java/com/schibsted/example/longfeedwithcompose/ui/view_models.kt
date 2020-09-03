package com.schibsted.example.longfeedwithcompose.ui

data class NewsItem(
    val title: String,
    val imageUrl: String,
    val date: String,
    val category: String,
    val caption: String
)

data class LatestData(val articles: List<NewsItem>, val next: String)