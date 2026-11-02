package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
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
            finish()
        }
        val agreementButton = findViewById<Button>(R.id.agreement_button)
        agreementButton.setOnClickListener {
            val url = "https://yandex.ru/legal/practicum_offer/ru/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        val supportButton = findViewById<Button>(R.id.support_button)
        supportButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.my_mail)))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.support_mail_main))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.support_mail_body))
            }
            startActivity(Intent.createChooser(emailIntent, "Отправить письмо"))
        }//AI Assistant, я пытался сам написать эту часть, но почему-то у меня не хотел метод putExtra() передавать сообщения, сет он клик, каким он был изначально, я оставил в файле README
        val shareButton = findViewById<Button>(R.id.share_button)
        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply{
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT,getString(R.string.share_app_text))
            }
            startActivity(shareIntent)
        }
    }
}
