package com.inpows.weapow.domain

import com.inpows.weapow.domain.city.interactor.LoadCityInteractor
import com.inpows.weapow.domain.city.repository.CityRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version LoadCityInteractorTest, v 0.1 25/04/22 12.06 by Fauhan Handay Pugar
 */
@RunWith(MockitoJUnitRunner::class)
class LoadCityInteractorTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    private lateinit var loadCityInteractor: LoadCityInteractor

    @Mock
    private lateinit var mockCityRepository: CityRepository

    @Mock
    private lateinit var mockCoroutineDispatcher: CoroutineDispatcher

    @Before
    fun setup(){
        loadCityInteractor = LoadCityInteractor(
            mockCoroutineDispatcher,
            mockCityRepository
        )
    }

    @Test
    fun testLoadCityUseCasePositiveCase() {
        loadCityInteractor.execute(Unit)
        Mockito.verify(mockCityRepository, Mockito.times(1))
            .loadCity()
    }

}