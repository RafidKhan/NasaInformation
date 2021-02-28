package com.example.nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa.databinding.ActivityMainBinding
import com.example.nasa.model.NasaResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    val BASE_URL = "https://api.nasa.gov/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mRecyclerView: RecyclerView? = null

        var client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)


        var rf = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()

        var API = rf.create(MyApiCall::class.java)

        var call = API.getMovieData()

        call?.enqueue(object : Callback<NasaResponse?> {
            override fun onResponse(
                call: Call<NasaResponse?>,
                response: Response<NasaResponse?>
            ) {
                var nasaList = response
                var adapterImage: NasaAdapter? =
                    nasaList.body()?.let { NasaAdapter(it, applicationContext) }

                Log.d("OnResponse", nasaList.code().toString() +" "+nasaList.message())
                binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                binding.recyclerView.adapter = adapterImage
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<NasaResponse?>, t: Throwable) {
                Log.d("OnResponse", t.toString())
            }


        })

    }
}