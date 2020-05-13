package br.com.jheimesilveira.app.ui.list_movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.jheimesilveira.app.R
import br.com.jheimesilveira.app.data.entitie.Movie
import br.com.jheimesilveira.app.util.CommonUtil
import kotlinx.android.synthetic.main.adapter_item_movie.view.*

class ListMovieAdapter(
    private val context: Context,
    private var movies: List<Movie> = ArrayList()
) : RecyclerView.Adapter<ListMovieAdapter.MovieViewHolder>() {
    private lateinit var itemClickListener: ((movie: Movie) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): MovieViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.adapter_item_movie, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun getItemCount() = movies.count()

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        with(movies[position]) {
            viewHolder.tvTitle.text = title
            viewHolder.tvYear.text = releaseDate
            viewHolder.tvRating.text = voteAverage.toString()
            viewHolder.tvOverview.text = overview

            context.let {
                CommonUtil.loadImage(it, viewHolder.ivImage, posterPath)
            }

            viewHolder.itemView.setOnClickListener {
                itemClickListener.invoke(this)
            }
        }

    }

    fun update(movies: List<Movie>) {
        this.movies = movies;
        notifyDataSetChanged()
    }

    fun onItemClickListener(itemClickListener: ((movie: Movie) -> Unit)) {
        this.itemClickListener = itemClickListener;
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvYear: TextView = itemView.tvYear
        val tvTitle: TextView = itemView.tvTitle
        val tvOverview: TextView = itemView.tvOverview
        val tvRating: TextView = itemView.tvRating
        val ivImage: ImageView = itemView.ivImage
    }
}