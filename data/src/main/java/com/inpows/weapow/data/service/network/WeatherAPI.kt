package com.inpows.weapow.data.service.network

import com.inpows.weapow.data.dashboard.model.weather.WeatherRootDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val KEY = "5489958f73d91efc2901b8dde1cb0fab"

interface WeatherAPI {

    @GET("weather")
    suspend fun loadWeatherByCityId(
        @Query("id") cityId: String,
        @Query("units") temp: String = "metric",
        @Query("appid") appId: String = KEY
    ) : Response<WeatherRootDto>

}