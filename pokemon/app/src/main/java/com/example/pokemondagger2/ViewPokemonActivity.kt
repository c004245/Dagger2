package com.example.pokemondagger2

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import javax.inject.Inject

class ViewPokemonActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModel: ViewPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

    }
}