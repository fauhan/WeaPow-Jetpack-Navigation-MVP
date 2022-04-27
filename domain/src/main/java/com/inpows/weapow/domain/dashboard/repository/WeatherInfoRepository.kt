package com.inpows.weapow.domain.dashboard.repository

import com.inpows.weapow.domain.dashboard.model.WeatherRootDomain
import kotlinx.coroutines.flow.Flow

interface WeatherInfoRepository {
    fun getWeather(cityId: String): Flow<WeatherRootDomain>
}