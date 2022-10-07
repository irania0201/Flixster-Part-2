package com.codepath.articlesearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

const val SHOW_EXTRA = "SHOW_EXTRA"
private const val TAG = "ArticleAdapter"
private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"

class ArticleAdapter(private val context: Context, private val shows: List<Show>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Get the individual article and bind to holder
        val show = shows[position]
        holder.bind(show)
    }

    override fun getItemCount() = shows.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.showImage)
        private val titleTextView = itemView.findViewById<TextView>(R.id.showTitle)
        private val airdateTextView = itemView.findViewById<TextView>(R.id.airDate)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(show: Show) {
            titleTextView.text = show.name
            airdateTextView.text = show.airDate

            val radius = 30
            val margin = 10
            Glide.with(context)
                .load(IMAGE_BASE_URL+ show.poster)
                .centerCrop() // scale image to fill the entire ImageView
                .transform(RoundedCorners(radius))
                .into(mediaImageView)
        }

        override fun onClick(v: View?) {
            // TODO: Get selected article
            val show = shows[absoluteAdapterPosition]

            // TODO: Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(SHOW_EXTRA, show)
            context.startActivity(intent)
        }
    }
}