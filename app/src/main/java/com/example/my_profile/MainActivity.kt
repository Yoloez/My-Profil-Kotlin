package com.example.my_profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Instagram
    fun openInstagram(view: View) {
        val instagramUrl = "https://www.instagram.com/hnfja"
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl))
            intent.setPackage("com.instagram.android")
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl)))
        }
    }

    // YouTube
    fun openYouTube(view: View) {
        val youtubeUrl = "https://www.youtube.com/@yoloez"
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            intent.setPackage("com.google.android.youtube")
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl)))
        }
    }

    // Gmail
    fun openGmail(view: View) {
        val email = "hananfijananto@gmail.com"
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
            putExtra(Intent.EXTRA_SUBJECT, "Subjek Email")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // LinkedIn
    fun openLinkedIn(view: View) {
        val linkedInUrl = "https://www.linkedin.com/in/hanan-fijananto-1362152b7/"
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl))
            intent.setPackage("com.linkedin.android")
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl)))
        }
    }
}