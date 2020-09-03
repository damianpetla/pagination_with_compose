package com.schibsted.example.longfeedwithcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schibsted.example.longfeedwithcompose.api.NewsService
import com.schibsted.example.longfeedwithcompose.toData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class NewsViewModel : ViewModel() {

    private val _newsState = MutableStateFlow(LatestData(emptyList(), ""))
    val newsState: StateFlow<LatestData> get() = _newsState

    private val newsService = Retrofit.Builder()
        .baseUrl("https://omni-content.omni.news/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(NewsService::class.java)

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            try {
                val response = newsService.getLatest()
                _newsState.value = response.toData()
            } catch (ex: Exception) {
                com.schibsted.example.longfeedwithcompose.error(ex)
            }
        }
    }

    fun getMoreNews() {
        viewModelScope.launch {
            try {
                val response = newsService.getMoreArticles(_newsState.value.next)
                _newsState.value = response.toData(_newsState.value.articles)
            } catch (ex: Exception) {
                com.schibsted.example.longfeedwithcompose.error(ex)
            }
        }
    }

    fun onSelectedNews(news: NewsItem) {

    }
}