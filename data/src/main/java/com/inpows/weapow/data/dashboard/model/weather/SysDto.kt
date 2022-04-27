package com.inpows.weapow.data.dashboard.model.weather

import com.google.gson.annotations.SerializedName

data class SysDto(
    @SerializedName("type")
    var type: Int = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("country")
    var country: String="",
    @SerializedName("sunrise")
    var sunrise: Int = 0,
    @SerializedName("sunset")
    var sunset: Int = 0
)
