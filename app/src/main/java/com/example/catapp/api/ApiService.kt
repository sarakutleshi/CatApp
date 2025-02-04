package com.example.catapp.api

import com.example.catapp.models.CatImage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/images/search")
    suspend fun getCatImages(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1
    ): Response<List<CatImage>>
}