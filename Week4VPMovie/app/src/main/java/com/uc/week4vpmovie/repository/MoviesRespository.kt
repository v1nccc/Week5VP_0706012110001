package com.uc.week4vpmovie.repository

import com.uc.week4vpmovie.retrofit.EndPointApi
import javax.inject.Inject

class MoviesRespository @Inject constructor(private val api: EndPointApi){
    suspend fun getNowPlayingData(apiKey: String, language: String, page:Int) = api.getNowPlaying(apiKey,language,page)
    suspend fun getNowMovieDetails(apiKey: String,  id:Int) = api.getMovieDetails(id, apiKey)
}