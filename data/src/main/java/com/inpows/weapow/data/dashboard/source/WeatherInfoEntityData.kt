package com.inpows.weapow.data.dashboard.source

import com.inpows.weapow.domain.dashboard.model.WeatherRootDomain
import kotlinx.coroutines.flow.Flow

interface WeatherInfoEntityData {
    fun getWeatherInfo(cityId: String): Flow<WeatherRootDomain>
}