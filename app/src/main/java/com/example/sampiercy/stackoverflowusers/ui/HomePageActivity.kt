package com.example.sampiercy.stackoverflowusers.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.sampiercy.stackoverflowusers.R
import com.example.sampiercy.stackoverflowusers.data.model.UsersResponse
import com.example.sampiercy.stackoverflowusers.extensions.isNetworkAvailable
import com.example.sampiercy.stackoverflowusers.ui.adapter.HomePageAdapter
import com.example.sampiercy.stackoverflowusers.viewmodels.StackOverflowViewModel
import com.example.sampiercy.stackoverflowusers.viewmodels.StackOverflowViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_home_page.*
import java.util.*
import javax.inject.Inject

class HomePageActivity : DaggerAppCompatActivity() {

    /*  @Inject*/
    private lateinit var stackOverflowViewModel: StackOverflowViewModel

    @Inject
    lateinit var stackOverflowViewModelFactory: StackOverflowViewModelFactory

    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        stackOverflowViewModel = ViewModelProviders.of(this, stackOverflowViewModelFactory).get(StackOverflowViewModel::class.java)

        compositeDisposable = CompositeDisposable()

        recyclerView.layoutManager = LinearLayoutManager(this)

        progressLoader.visibility = View.VISIBLE
        recyclerView.adapter = HomePageAdapter(UsersResponse(LinkedList()), this)

        if (isNetworkAvailable())
            compositeDisposable?.add(
                    stackOverflowViewModel.getTopTwentyUsers(false).subscribeBy(
                            onSuccess = {
                                progressLoader.visibility = View.GONE
                                (recyclerView.adapter as HomePageAdapter).updateUserResponse(it)
                            },
                            onError = {
                                progressLoader.visibility = View.GONE
                                showErrorMessage(getString(R.string.something_went_wrong))
                            }
                    )
            )
        else showErrorMessage(getString(R.string.no_internet))

        swipeRefresh.setOnRefreshListener {
            refresh { swipeRefresh.isRefreshing = false }
        }

    }

    private fun refresh(doAfter: () -> Unit) {
        if (isNetworkAvailable())
            compositeDisposable?.add(
                    stackOverflowViewModel.getTopTwentyUsers(true).subscribeBy(
                            onSuccess = {
                                doAfter()
                                (recyclerView.adapter as HomePageAdapter).updateUserResponse(it)
                            },
                            onError = {
                                doAfter()
                                showErrorMessage(getString(R.string.something_went_wrong))
                            }
                    )
            )
        else {
            doAfter()
            showErrorMessage(getString(R.string.no_internet))
        }

    }

    private fun showErrorMessage(message: String) {
        AlertDialog.Builder(this).setMessage(message)
                .setTitle(R.string.error)
                .setNegativeButton(
                        R.string.cancel,
                        { dialog, _ -> dialog.dismiss() }
                )
                .setPositiveButton(R.string.retry, { _, _ ->
                    progressLoader.visibility = View.VISIBLE
                    refresh { progressLoader.visibility = View.GONE }
                })
                .create()
                .show()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_refresh) {
            swipeRefresh.isRefreshing = true
            refresh { swipeRefresh.isRefreshing = false }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.dispose()
    }

}
