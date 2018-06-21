package com.example.apresentation.ui.beers

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.apresentation.R
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.widget.Toast
import com.example.apresentation.ui.beersdetails.BeerDetailActivity
import com.example.domain.entities.Beer


class BeersRecyclerAdapter(presenter : BeersContract.Presenter) : RecyclerView.Adapter<BeersRecyclerAdapter.BeerViewHolder>() {

    private val recyclerPresenter : BeersContract.Presenter = presenter


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {

        return BeerViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.beer_row, parent, false))
    }

    override fun getItemCount(): Int {
        var size = recyclerPresenter.getBeerRowCount()
        Log.e("Size", size.toString())
        return size
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {

        recyclerPresenter.onBindBeerRowViewAtPosition(position, holder)
    }

    inner class BeerViewHolder(view : View) : RecyclerView.ViewHolder(view), BeerRowView{

        private val beerNameTextView: TextView = view.findViewById(R.id.textView_beer_name)
        private val beerTagLineTextView: TextView = view.findViewById(R.id.textView_beer_tag_line)
        private val beerImageView: ImageView = view.findViewById(R.id.imageView_beer_recycler)
        private val myView : View = view


        override fun setBeerName(beerName: String) {
            beerNameTextView.text = beerName

        }

        override fun setBeerTagLine(beerTagLine: String) {

            beerTagLineTextView.text = beerTagLine
        }

        override fun setBeerImg(beerImage: String) {

            Glide.with(beerImageView.context)
                    .load(beerImage)
                    .asBitmap()
                    .into(beerImageView)

        }

        fun fireIntent(context: Context, beer: Beer) {


            val intent = Intent(context, BeerDetailActivity::class.java)
            intent.putExtra("Beer", beer)

            context.startActivity(intent)
        }

        override fun setClickListener(beer: Beer) {

            myView.setOnClickListener {
                Log.d("OnClick", "onClick: clicked on: ")

                Toast.makeText(myView.context, beer.beerName, Toast.LENGTH_SHORT).show()

                fireIntent(myView.context, beer)

            }
        }

    }


}