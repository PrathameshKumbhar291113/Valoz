package com.valorantagentsapplicationcleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valorantagentsapplicationcleanarchitecture.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ValorantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_valorant)
    }
}