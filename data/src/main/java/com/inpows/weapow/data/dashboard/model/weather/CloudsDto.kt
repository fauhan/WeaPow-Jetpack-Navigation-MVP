package com.inpows.weapow.data.dashboard.model.weather

import com.google.gson.annotations.SerializedName

data class CloudsDto(
    @SerializedName("all")
    var all: Int = 0
)
