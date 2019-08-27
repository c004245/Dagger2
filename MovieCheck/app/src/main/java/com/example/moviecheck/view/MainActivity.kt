package com.example.moviecheck.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecheck.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frameLayoutRoot, mainFragment)
                .commit()
        }
    }
}
