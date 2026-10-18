package com.example.rickandmorty.network

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitClient {

    // El JSON trae campos que no declaramos (origin, location, episode...): los ignoramos.
    private val json = Json { ignoreUnknownKeys = true }

    val api: RickAndMortyApi = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")   // siempre termina en /
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(RickAndMortyApi::class.java)
}
