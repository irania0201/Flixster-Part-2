package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"
private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"

class DetailActivity : AppCompatActivity() {
    private lateinit var backdropImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var voteTextView: TextView
    private lateinit var overviewTextView: TextView
    private lateinit var langTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        backdropImageView = findViewById(R.id.mediaImage)
        nameTextView = findViewById(R.id.mediaTitle)
        voteTextView = findViewById(R.id.mediaByline)
        overviewTextView = findViewById(R.id.showOverview)
        langTextView = findViewById<TextView>(R.id.language)

        // TODO: Get the extra from the Intent
        val show = intent.getSerializableExtra(SHOW_EXTRA) as Show

        // TODO: Set the title, byline, and abstract information from the article
        nameTextView.text = show.name
        voteTextView.text = show.vote
        overviewTextView.text = show.overview
        langTextView.text = show.lang

        // TODO: Load the media image
        Glide.with(this)
            .load(IMAGE_BASE_URL+show.backdrop)
            .into(backdropImageView)
    }
}