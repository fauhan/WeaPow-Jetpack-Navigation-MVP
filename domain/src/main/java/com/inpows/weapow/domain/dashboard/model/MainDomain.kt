package com.inpows.weapow.domain.dashboard.model

data class MainDomain(
    var temp: Double = 0.0,
    var feelsLike: Double = 0.0,
    var tempMin: Double = 0.0,
    var tempMax: Double = 0.0,
    var pressure: Int = 0,
    var humidity: Int = 0
)
