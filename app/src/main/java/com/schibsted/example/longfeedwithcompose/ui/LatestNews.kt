package com.schibsted.example.longfeedwithcompose.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.onActive
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun LatestNewsScreen(viewModel: NewsViewModel) {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Pagination with Compose") })
            },
            bodyContent = {
                LatestNewsFeed(viewModel = viewModel)
            }
        )
    }
}

@ExperimentalCoroutinesApi
@Composable
fun LatestNewsFeed(viewModel: NewsViewModel) {
    val state = viewModel.newsState.collectAsState()
    val lastIndex = state.value.articles.lastIndex
    LazyColumnForIndexed(items = state.value.articles) { i, newsItem ->
        if (lastIndex == i) {
            onActive {
                viewModel.getMoreNews()
            }
        }
        NewsCard(newsItem) {
            viewModel.onSelectedNews(newsItem)
        }
    }
}
