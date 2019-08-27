package com.example.moviecheck

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecheck.model.Movie
import com.squareup.picasso.Picasso
import javax.inject.Inject

class MainAdapter @Inject constructor(private var picasso: Picasso): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    lateinit var listMovie: List<Movie>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }


    fun setMovies(movies: List<Movie>) {
        this.listMovie = movies
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (listMovie == null) 0 else listMovie.size

    }

    inner class MainViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        private var movieTitle: TextView = itemView.findViewById(R.id.textViewMovieTitle)
        private var moviePoster: ImageView = itemView.findViewById(R.id.imageViewMoviePoster)

        fun bind(movie: Movie) {
           movieTitle.text = movie.title
            picasso.load("https://image.tmdb.org/t/p/w342" + movie.posterPath)
                .centerCrop()
                .fit()
                .into(moviePoster)
       }
   }

}