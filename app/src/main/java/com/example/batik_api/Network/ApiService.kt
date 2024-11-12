package com.example.batik_api.Network

import com.example.batik_api.Model.BatikResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("batik/all")
    fun getAllBatik(): Call<BatikResponse>
}