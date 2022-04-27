package com.inpows.weapow.data.dashboard.source

import com.inpows.weapow.data.dashboard.mapper.toWeatherInfo
import com.inpows.weapow.data.service.network.WeatherAPI
import com.inpows.weapow.domain.dashboard.model.WeatherRootDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class NetworkWeatherInfoEntityData @Inject constructor(
    private val weatherAPI: WeatherAPI
) : WeatherInfoEntityData {

    override fun getWeatherInfo(cityId: String): Flow<WeatherRootDomain> {
        return flow {
            val weatherResult = weatherAPI.loadWeatherByCityId(cityId)
            Timber.d("Response Service ${weatherResult.toString()}")
            if(weatherResult.isSuccessful){
                val weatherRootRes = weatherResult.body()
                if(weatherRootRes != null){
                    emit(weatherRootRes.toWeatherInfo())
                } else {
                    emit(WeatherRootDomain())
                }
            } else {
                Timber
                emit(WeatherRootDomain())
            }
        }
    }
}