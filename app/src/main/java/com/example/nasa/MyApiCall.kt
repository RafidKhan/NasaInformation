package com.example.nasa

import com.example.nasa.model.NasaResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MyApiCall {
    @GET("planetary/apod?api_key=azovyURRnZ1SWqG185n4sSdmvBNJcJR9T5yHI6g2")
    fun getMovieData(): Call<NasaResponse?>?
}