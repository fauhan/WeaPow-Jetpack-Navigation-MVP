package com.inpows.weapow.data.dashboard.model

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("main")
    var main: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("icon")
    var icon: String = ""
)
