package com.example.apresentation.ui.beersdetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.apresentation.R
import com.example.domain.entities.Beer

class BeerDetailActivity : AppCompatActivity() {

    private lateinit var beer : Beer

    private lateinit var beerNameTextView: TextView
    private lateinit var beerTagLineTextView: TextView
    private lateinit var beerImageView: ImageView
    private lateinit var beerDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beer_detail_view)

        beerNameTextView = findViewById(R.id.textView_beer_name_detail)
        beerTagLineTextView = findViewById(R.id.textView_beer_tag_line_detail)
        beerImageView = findViewById(R.id.imageView_beer_detail)
        beerDescription = findViewById(R.id.beer_text_description)

        setupBeerDetail()
    }

    fun setupBeerDetail(){

        beer = intent.getSerializableExtra("Beer") as Beer

        beerNameTextView.text = beer.beerName
        beerTagLineTextView.text = beer.beerTagLine
        beerDescription.text = beer.beerDescription

        Glide.with(this)
                .load(beer.beerImg)
                .asBitmap()
                .into(beerImageView)


    }
}