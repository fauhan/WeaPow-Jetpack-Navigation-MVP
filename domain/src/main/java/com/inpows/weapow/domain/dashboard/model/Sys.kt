package com.inpows.weapow.domain.dashboard.model

data class Sys(
    var type: Int = 0,
    var id: Int = 0,
    var country: String="",
    var sunrise: Int = 0,
    var sunset: Int = 0
)
