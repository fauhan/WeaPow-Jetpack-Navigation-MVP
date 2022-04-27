package com.inpows.weapow.domain.dashboard.model

data class WeatherRootDomain(
    var coord: CoordinateDomain? = null,
    var weather: List<Weather> = listOf(),
    var base: String = "",
    var mainDomain: MainDomain? = null,
    var visibility: Int = 0,
    var wind: Wind? = null,
    var cloudsDomain: CloudsDomain? = null,
    var dt: Long = 0,
    var sys: Sys? = null,
    var timezone: Int = 0,
    var id: Int = 0,
    var name: String = "",
    var cod: Int = 0
)
