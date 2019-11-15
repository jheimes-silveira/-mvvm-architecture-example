package br.com.tqi.jheimesilveira.app.ui.movie

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.tqi.jheimesilveira.app.R
import br.com.tqi.jheimesilveira.app.ui.BaseActivity
import br.com.tqi.jheimesilveira.app.util.CommonUtil
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : BaseActivity() {
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        initComponents()
    }

    private fun initComponents() {
        loadExtras()
        initToolbar()
        observerMovie()
    }

    private fun initToolbar() {
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun loadExtras() {
        viewModel.getExtras(intent.getSerializableExtra(MOVIE))
    }

    private fun observerMovie() {
        viewModel.movie.observe(this, Observer { movie ->
            with(movie) {
                tvTitle.text = title
                tvYear.text = releaseDate
                tvRating.text = voteAverage.toString()
                tvOverview.text = overview

                toolbar.title = title

                CommonUtil.loadImage(this@MovieActivity, ivImage, posterPath)
            }

        })
    }

    companion object {
        const val MOVIE = "MOVIE"
    }
}
