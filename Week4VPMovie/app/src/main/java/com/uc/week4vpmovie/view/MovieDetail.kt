package com.uc.week4vpmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.uc.week4vpmovie.adapter.GenreAdapter
import com.uc.week4vpmovie.adapter.LanguageAdapter
import com.uc.week4vpmovie.adapter.ProductionAdapter
import com.uc.week4vpmovie.databinding.ActivityMovieDetailBinding
import com.uc.week4vpmovie.helper.Const
import com.uc.week4vpmovie.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetail : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var genreadapter: GenreAdapter
    private lateinit var languageAdapter: LanguageAdapter
    private lateinit var productionadapter: ProductionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGenre.visibility = View.INVISIBLE
        binding.rvlanguage.visibility = View.INVISIBLE
        binding.rvProductionCompany.visibility = View.INVISIBLE
        binding.textView6.visibility = View.INVISIBLE
        binding.textView2.visibility = View.INVISIBLE
        binding.textView4.visibility = View.INVISIBLE
        binding.textView5.visibility = View.INVISIBLE
        binding.imgPosterMovieDetail.visibility = View.INVISIBLE
        binding.tvTitleMovieDetail.visibility = View.INVISIBLE



        val movieId = intent.getIntExtra("movie_id",0)

        Toast.makeText(applicationContext,"Movie ID:${movieId}",Toast.LENGTH_SHORT).show()
        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getMovieDetails(Const.API_KEY, movieId)
        viewModel.movieDetails.observe(
            this,{
                response ->

                if (response != null){

                    binding.progressBar.visibility = View.INVISIBLE
                    binding.rvGenre.visibility = View.VISIBLE
                    binding.rvlanguage.visibility = View.VISIBLE
                    binding.rvProductionCompany.visibility = View.VISIBLE
                    binding.textView6.visibility = View.VISIBLE
                    binding.textView2.visibility = View.VISIBLE
                    binding.textView4.visibility = View.VISIBLE
                    binding.textView5.visibility = View.VISIBLE
                    binding.imgPosterMovieDetail.visibility = View.VISIBLE
                    binding.tvTitleMovieDetail.visibility = View.VISIBLE
                }

                binding.tvTitleMovieDetail.apply {
                    text = response.title
                }

                binding.overviewtext.apply {
                    text = response.overview
                }

                Glide.with(applicationContext)
                    .load(Const.IMG_URL + response.backdrop_path).into(binding.imgPosterMovieDetail)

                binding.rvGenre.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
                genreadapter= GenreAdapter(response.genres)
                binding.rvGenre.adapter = genreadapter

                binding.rvlanguage.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
                languageAdapter= LanguageAdapter(response.spoken_languages)
                binding.rvlanguage.adapter = languageAdapter

                binding.rvProductionCompany.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
                productionadapter= ProductionAdapter(response.production_companies)
                binding.rvProductionCompany.adapter = productionadapter
            }


        )

    }
}