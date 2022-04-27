package com.inpows.weapow.data.dashboard.source

import com.inpows.weapow.data.AbstractEntityDataFactory
import com.inpows.weapow.data.Source
import javax.inject.Inject


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version WeatherInfoEntityDataFactory, v 0.1 20/04/22 12.20 by Fauhan Handay Pugar
 */
class WeatherInfoEntityDataFactory @Inject constructor(
    private val networkWeatherInfoEntityData: NetworkWeatherInfoEntityData
) : AbstractEntityDataFactory<WeatherInfoEntityData>() {
    override fun createData(source: String?): WeatherInfoEntityData {
        return when(source){
            Source.NETWORK -> networkWeatherInfoEntityData
            else -> networkWeatherInfoEntityData
        }
    }
}