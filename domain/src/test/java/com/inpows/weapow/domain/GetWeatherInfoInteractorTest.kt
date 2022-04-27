package com.inpows.weapow.domain

import com.inpows.weapow.domain.dashboard.interactor.GetWeatherInfoInteractor
import com.inpows.weapow.domain.dashboard.repository.WeatherInfoRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version GetWeatherInfoInteractorTest, v 0.1 22/04/22 13.09 by Fauhan Handay Pugar
 */
@RunWith(MockitoJUnitRunner::class)
class GetWeatherInfoInteractorTest {

    companion object {
        const val cityId = "123"
    }

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    private lateinit var getWeatherInfoInteractor: GetWeatherInfoInteractor

    @Mock
    private lateinit var mockWeatherInfoRepository: WeatherInfoRepository

    @Mock
    private lateinit var mockCoroutineDispatcher: CoroutineDispatcher

    @Before
    fun setUp() {
        getWeatherInfoInteractor = GetWeatherInfoInteractor(
            mockCoroutineDispatcher,
            mockWeatherInfoRepository
        )
    }

    @Test
    fun testGetCurrentWeatherUseCasePositiveCase() {
        getWeatherInfoInteractor.execute(
            GetWeatherInfoInteractor.Params(cityId)
        )

        verify(mockWeatherInfoRepository, times(1)).getWeather(cityId)
    }

//    @Test
//    fun testGetCurrentWeatherUseCaseNoInteractionCase() {
//        getWeatherInfoInteractor.execute(
//            GetWeatherInfoInteractor.Params(cityId)
//        )
//
//        verifyNoInteractions(mockWeatherInfoRepository)
//    }

}