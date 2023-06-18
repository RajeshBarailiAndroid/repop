package com.jptest.realogyapp.network

import android.util.Log
import com.jptest.realogyapp.model.Characters
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


@Singleton
class CharacterRepository @Inject constructor(
    private val apiService: ApiService, @Named("parameter_string") val params: String
) {
    suspend fun getCharacters(): Characters {
        Log.e("TAG", "getCharacters: ---------"+apiService.getCharacters(params) )
        return apiService.getCharacters(params)
    }
}
