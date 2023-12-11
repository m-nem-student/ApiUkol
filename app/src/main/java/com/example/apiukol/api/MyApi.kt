package com.example.apiukol.api

import com.example.apiukol.model.Contents
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface MyApi {

    companion object {
        const val SUBJECT_INFO_ENDPOINT = "ISteamUserStats/GetNumberOfCurrentPlayers/v1"
    }

    @GET(SUBJECT_INFO_ENDPOINT)
    fun getPlayers(
        @Query("appid") appid: Int
    ): Call<Contents>
}