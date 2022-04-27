package com.inpows.weapow.data.city.source

import com.inpows.weapow.data.service.local.SharedPrefs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version LocalChangeCityEntityData, v 0.1 24/04/22 17.53 by Fauhan Handay Pugar
 */
class LocalChangeCityEntityData @Inject constructor(
    private val sharedPrefs: SharedPrefs
): ChangeCityEntityData {
    override fun saveCity(cityId: String): Flow<String> {
        return flow{
            sharedPrefs.put(SharedPrefs.PREF_CITY_ID, cityId)
            emit(cityId)
        }
    }

    override fun loadCityName(): Flow<String> {
        return flow {
            emit(sharedPrefs.get(SharedPrefs.PREF_CITY_ID, String::class.java))
        }
    }
}