package com.inpows.weapow.data.dashboard.model.weather

import com.google.gson.annotations.SerializedName

data class MainDto(
    @SerializedName("temp")
    var temp: Double = 0.0,
    @SerializedName("feels_like")
    var feelsLike: Double = 0.0,
    @SerializedName("temp_min")
    var tempMin: Double = 0.0,
    @SerializedName("temp_max")
    var tempMax: Double = 0.0,
    @SerializedName("pressure")
    var pressure: Int = 0,
    @SerializedName("humidity")
    var humidity: Int = 0
)
