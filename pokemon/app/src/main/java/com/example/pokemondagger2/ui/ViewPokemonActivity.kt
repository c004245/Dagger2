package com.example.pokemondagger2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class ViewPokemonActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModel: ViewPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

    }
}