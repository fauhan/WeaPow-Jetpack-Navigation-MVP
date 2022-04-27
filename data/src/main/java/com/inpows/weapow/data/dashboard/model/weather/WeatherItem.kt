package com.inpows.weapow.data.dashboard.model.weather

import androidx.annotation.DrawableRes

data class WeatherItem(
    @DrawableRes val resIcon: Int,
    val label: String,
    val value: String
)
