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
 * @version LoadCityNameInteractor, v 0.1 24/04/22 20.58 by Fauhan Handay Pugar
 */
class LoadCityInteractor @Inject constructor(
    @DefaultDispatcher dispatcher: CoroutineDispatcher,
    private val cityRepository: CityRepository
) : FlowUseCase<Unit, String>(dispatcher){
    override fun execute(params: Unit): Flow<Result<String>> {
        return cityRepository.loadCity().map {
            Result.Success(it)
        }
    }
}