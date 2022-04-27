package com.inpows.weapow.data.city.repository

import com.inpows.weapow.data.city.source.LocalChangeCityEntityData
import com.inpows.weapow.domain.city.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ChangeCityEntityRepository, v 0.1 24/04/22 16.40 by Fauhan Handay Pugar
 */
class CityEntityRepository @Inject constructor(
    private val localEntityData: LocalChangeCityEntityData
): CityRepository {
    override fun loadCity(): Flow<String> {
        return localEntityData.loadCityName()
    }

    override fun saveCity(cityId: String): Flow<String> {
        return localEntityData.saveCity(cityId)
    }
}