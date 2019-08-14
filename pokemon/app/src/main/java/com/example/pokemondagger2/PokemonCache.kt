package com.example.pokemondagger2

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonCache @Inject constructor() {
    private var items: List<Pokemon>? = null

    fun hasData(): Boolean {
        return synchronized(this) {
            items != null
        }
    }

    fun getItems(): List<Pokemon> {
        return synchronized(this) {
            items.orEmpty()
        }
    }

    fun saveItems(newItems: List<Pokemon>) {
        synchronized(this) {
            items = newItems
        }
    }
}