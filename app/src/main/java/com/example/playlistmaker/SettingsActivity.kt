package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_settings)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val backSettingsButton = findViewById<ImageButton>(R.id.backSetting)
        backSettingsButton.setOnClickListener {
            val backSettingsIntent: Intent = Intent(this, MainActivity::class.java)
            startActivity(backSettingsIntent)
        }
    }
    }
