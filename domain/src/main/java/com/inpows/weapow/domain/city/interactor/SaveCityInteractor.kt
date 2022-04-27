package com.inpows.weapow.domain.city.interactor

import com.inpows.weapow.domain.DefaultDispatcher
import com.inpows.weapow.domain.core.usecase.FlowUseCase
import com.inpows.weapow.domain.dashboard.model.Result
import com.inpows.weapow.domain.city.repository.CityRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version SaveCityInteractor, v 0.1 25/04/22 10.04 by Fauhan Handay Pugar
 */
class SaveCityInteractor @Inject constructor(
    @DefaultDispatcher dispatcher: CoroutineDispatcher,
    private val cityRepository: CityRepository
) : FlowUseCase<SaveCityInteractor.Params, String>(dispatcher) {
    data class Params(var cityId: String)

    override fun execute(params: Params): Flow<Result<String>> {
        return cityRepository.saveCity(params.cityId).map{
            Result.Success(it)
        }
    }
}