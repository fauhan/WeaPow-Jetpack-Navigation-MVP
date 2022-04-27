package com.inpows.weapow.data.dashboard.model.weather

import com.google.gson.annotations.SerializedName
import com.inpows.weapow.data.dashboard.model.CoordinateDto
import com.inpows.weapow.data.dashboard.model.WeatherDto

data class WeatherRootDto(
    @SerializedName("coord")
    var coord: CoordinateDto? = null,

    @SerializedName("weather")
    var weatherDto: List<WeatherDto> = listOf(),

    @SerializedName("base")
    var base: String = "",

    @SerializedName("main")
    var mainDto: MainDto? = null,

    @SerializedName("visibility")
    var visibility: Int = 0,

    @SerializedName("wind")
    var windDto: WindDto? = null,

    @SerializedName("clouds")
    var cloudsDto: CloudsDto? = null,

    @SerializedName("dt")
    var dt: Long = 0,

    @SerializedName("sys")
    var sysDto: SysDto? = null,

    @SerializedName("timezone")
    var timezone: Int = 0,

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("cod")
    var cod: Int = 0
)
