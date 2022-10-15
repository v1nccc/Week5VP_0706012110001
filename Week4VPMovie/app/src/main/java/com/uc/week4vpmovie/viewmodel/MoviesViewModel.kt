package com.uc.week4vpmovie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.week4vpmovie.model.Genre
import com.uc.week4vpmovie.model.MovieDetails
import com.uc.week4vpmovie.repository.MoviesRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.uc.week4vpmovie.model.Result
import kotlinx.coroutines.launch

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MoviesRespository) :
    ViewModel() {

    private val _nowPlaying: MutableLiveData<ArrayList<Result>> by lazy {
        MutableLiveData<ArrayList<Result>>()

    }

    val nowPlaying: LiveData<ArrayList<Result>>
        get() = _nowPlaying


    fun getNowPlaying(apiKey: String, language: String, page: Int) = viewModelScope.launch {
        repository.getNowPlayingData(apiKey, language, page).let { response ->
            if (response.isSuccessful) {
                _nowPlaying.postValue(response.body()?.results as ArrayList<Result>)
            } else {
                Log.e("Get Data", "Failed!")
            }

        }

    }
    // moviedetail
    private val _movieDetails: MutableLiveData<MovieDetails> by lazy {
        MutableLiveData<MovieDetails>()

    }

    val movieDetails: LiveData<MovieDetails>
        get() = _movieDetails


    fun getMovieDetails(apiKey: String, id: Int) = viewModelScope.launch {
        repository.getNowMovieDetails(apiKey, id).let { response ->
            if (response.isSuccessful) {
                _movieDetails.postValue(response.body() as MovieDetails )
            } else {
                Log.e("Get Movie Details", "Failed!")
            }

        }

    }


}