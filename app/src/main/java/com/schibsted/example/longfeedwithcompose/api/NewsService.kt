package com.schibsted.example.longfeedwithcompose.api

import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService {

    @GET("articles?newsmix=latest")
    suspend fun getLatest(): LatestNewsResponse

    @GET
    suspend fun getMoreArticles(@Url next: String) : LatestNewsResponse
}