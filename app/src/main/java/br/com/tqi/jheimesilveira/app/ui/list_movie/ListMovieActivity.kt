package br.com.tqi.jheimesilveira.app.ui.list_movie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tqi.jheimesilveira.app.R
import br.com.tqi.jheimesilveira.app.ui.BaseActivity
import br.com.tqi.jheimesilveira.app.ui.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_list_movie.*

class ListMovieActivity : BaseActivity() {
    private lateinit var viewModel: ListMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(ListMovieViewModel::class.java)

        initComponents()
    }

    private fun initComponents() {
        initSearchView()
        initRecyclerView()
        initEmptyState()
        initProgressBar()
    }

    private fun initProgressBar() {
        viewModel.load.observe(this, Observer {
            it?.let { progressBar(it) }
        })
    }

    private fun initEmptyState() {
        viewModel.emptyState.observe(this, Observer { visible ->
            animationCrying.visibility = visible
        })
    }

    private fun initRecyclerView() {
        viewModel.page.observe(this, Observer {
            it?.let { page ->
                with(recyclerView) {
                    layoutManager = LinearLayoutManager(this@ListMovieActivity)

                    adapter = ListMovieAdapter(this@ListMovieActivity, page.results) { movie ->
                        Intent(this@ListMovieActivity, MovieActivity::class.java).apply {
                            putExtra(MovieActivity.MOVIE, movie)

                            startActivity(this)
                        }
                    }
                }
            }
        })
    }

    private fun initSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.getQueryMovie(it) }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        viewModel.getQueryMovie("a")
    }
}
