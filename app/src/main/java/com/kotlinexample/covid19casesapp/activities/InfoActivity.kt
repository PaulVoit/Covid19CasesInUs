package com.kotlinexample.covid19casesapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.kotlinexample.covid19casesapp.R

class InfoActivity : AppCompatActivity() {
    private lateinit var mTextInfo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mTextInfo = findViewById(R.id.textView)
        val mImageInfo: ImageView = findViewById(R.id.imageView)
        var buttonRateApp: Button = findViewById(R.id.buttonRateApp)
        buttonRateApp.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=${applicationContext.packageName}")
                )
            )
        }
    }
}