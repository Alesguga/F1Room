package net.azarquiel.recandroid1ev.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import net.azarquiel.recandroid1ev.R

class ActivityWeb : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val link = intent.getStringExtra("link")

        val wv = findViewById<WebView>(R.id.wv)
        wv.loadUrl(link!!)
    }
}
