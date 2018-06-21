package com.example.apresentation.ui.beers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.apresentation.R
import com.example.domain.entities.Beer

class BeersActivity: AppCompatActivity(), BeersContract.View {

    private val beerPresenter: BeersContract.Presenter = BeersPresenter()
    private lateinit var beerRecycler: RecyclerView
    private lateinit var beerAdapter : BeersRecyclerAdapter
    private lateinit var beerLayoutManager : LinearLayoutManager


    override fun showBeers() {
        Log.d("onCreate", "showBeers")

        beerRecycler = findViewById(R.id.beer_recycler_view)
        beerAdapter = BeersRecyclerAdapter(beerPresenter)
        beerLayoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(beerRecycler.context,
                beerLayoutManager.orientation)
        beerRecycler.addItemDecoration(dividerItemDecoration)

        beerRecycler.adapter = beerAdapter
        beerRecycler.layoutManager = beerLayoutManager

    }

    override fun showBeerDetail(beerId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("onCreate", "onCreateActivity")
        setContentView(R.layout.beer_activity)

        beerPresenter.attachView(this)
        beerPresenter.loadBeers()

    }

    override fun onDataChanged() {
        beerAdapter.notifyDataSetChanged()
    }

    override fun isLoadingData(loading: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorResponse(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}