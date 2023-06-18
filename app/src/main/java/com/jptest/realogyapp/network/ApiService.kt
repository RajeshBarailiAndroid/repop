package com.jptest.realogyapp.network

import com.jptest.realogyapp.model.Characters
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getCharacters(
        @Query("q") query: String,
        @Query("format") format: String = "json"
    ): Characters
}
