package com.example.rickandmorty.data

import com.example.rickandmorty.model.Personaje
import com.example.rickandmorty.network.RetrofitClient
import com.example.rickandmorty.network.RickAndMortyApi

class PersonajeRepository (private val api: RickAndMortyApi = RetrofitClient.api) {

    suspend fun obtenerLista(): List<Personaje> =
        api.obtenerPersonajes().results


    suspend fun obtenerDetalle(id: Int): Personaje =
        api.obtenerPersonaje(id)

}