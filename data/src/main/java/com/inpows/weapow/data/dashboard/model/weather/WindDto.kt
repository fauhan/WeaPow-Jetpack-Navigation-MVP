package com.inpows.weapow.data.dashboard.model.weather

import com.google.gson.annotations.SerializedName

data class WindDto(
    @SerializedName("speed")
    var speed: Double = 0.0,
    @SerializedName("deg")
    var deg: Int = 0
)
