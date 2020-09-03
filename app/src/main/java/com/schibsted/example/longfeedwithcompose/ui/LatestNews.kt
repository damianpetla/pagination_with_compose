package com.schibsted.example.longfeedwithcompose.ui

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.onActive
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun LatestNews(viewModel: NewsViewModel) {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Apka testowa") })
            },
            bodyContent = {
                val state = viewModel.newsState.collectAsState()
                val size = state.value.articles.size
                LazyColumnForIndexed(items = state.value.articles) { i, newsItem ->
                    if (size - 2 == i) {
                        onActive {
                            viewModel.getMoreNews()
                        }
                    }
                    Box(
                        paddingBottom = 8.dp,
                        paddingTop = 8.dp,
                        paddingStart = 16.dp,
                        paddingEnd = 16.dp
                    ) {
                        NewsCard(newsItem) {
                            viewModel.onSelectedNews(newsItem)
                        }
                    }
                }
            }
        )
    }
}
