package com.example.apresentation.ui.beers

import android.annotation.SuppressLint
import android.util.Log
import com.example.data.repositories.BeerRepository
import com.example.domain.entities.Beer
import com.example.domain.entities.defaults.Packet
import com.example.domain.usecase.GetBeerList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BeersPresenter : BeersContract.Presenter {

    private val getBeerUseCase = GetBeerList(repository = BeerRepository())

    private lateinit var beerView : BeersContract.View

    private var list = mutableListOf<Beer>()

    override fun attachView(view: BeersContract.View) {
        beerView = view
    }

    @SuppressLint("CheckResult")
    override fun loadBeers() {

        Log.d("onCreate", "onCreatePresenter")

        getBeerUseCase
                .getObservable(Unit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { packet ->
                    when(packet){
                        is Packet.Sucess ->
                        //packet.data.forEach { Log.d("Beers", it.beerName) }
                        //beerView.showBeers(packet.data)
                        setRecyclerBeer(packet.data)

                        //is Packet.Loading ->
                    }
                }

        //beerView.showBeers(list)
    }

    override fun onBindBeerRowViewAtPosition(position : Int, view : BeerRowView){
            //var beer : Beer = Beer("beer", "beer", "beerurl", "bbbbbb")

            var beer : Beer = list[position]
            //Log.e("Teste", "=========================="+beer.beerName)

            view.setBeerName(beer.beerName)
            view.setBeerTagLine(beer.beerTagLine)
            view.setBeerImg(beer.beerImg)

            view.setClickListener(beer)



            //notifyDataChanged()
    }

    override fun getBeerRowCount(): Int {
            return list.size
    }

    override fun notifyDataChanged() {
        beerView.onDataChanged()
    }

    private fun setRecyclerBeer(data: List<Beer>){
        //data.forEach { Log.e("Beers", it.beerName) }

        list.clear()
        list.addAll(data)

        beerView.showBeers()
        //list.forEach { Log.e("Beers", it.beerName) }
    }

}