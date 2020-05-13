package br.com.jheimesilveira.app.ui.list_movie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.jheimesilveira.app.R
import br.com.jheimesilveira.app.ui.BaseActivity
import br.com.jheimesilveira.app.ui.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_list_movie.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListMovieActivity : BaseActivity() {
    val viewModel: ListMovieViewModel by viewModel()

    private lateinit var listMovieAdapter: ListMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movie)
        setSupportActionBar(toolbar)

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
        listMovieAdapter = initListMovieAdapter()

        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@ListMovieActivity)
            adapter = listMovieAdapter
        }

        viewModel.page.observe(this, Observer { page ->
            listMovieAdapter.update(page.results)
        })
    }

    private fun initListMovieAdapter(): ListMovieAdapter {
        val listMovieAdapter = ListMovieAdapter(context = baseContext)

        listMovieAdapter.onItemClickListener { movie ->
            Intent(this@ListMovieActivity, MovieActivity::class.java).apply {
                putExtra(MovieActivity.MOVIE, movie)

                startActivity(this)
            }
        }

        return listMovieAdapter
    }

    private fun initSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.getQueryMovie(query = it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
}
