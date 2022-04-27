package com.inpows.weapow.data.dashboard.repository

import com.inpows.weapow.data.dashboard.source.NetworkWeatherInfoEntityData
import com.inpows.weapow.domain.dashboard.model.WeatherRootDomain
import com.inpows.weapow.domain.dashboard.repository.WeatherInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherInfoEntityRepository @Inject constructor(
    private val networkEntityData: NetworkWeatherInfoEntityData
) : WeatherInfoRepository {
    override fun getWeather(cityName: String): Flow<WeatherRootDomain> {
        return networkEntityData.getWeatherInfo(cityName)
    }

}