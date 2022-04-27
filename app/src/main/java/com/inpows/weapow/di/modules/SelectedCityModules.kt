package com.inpows.weapow.di.modules

import com.inpows.weapow.di.PerActivity
import com.inpows.weapow.domain.DefaultDispatcher
import com.inpows.weapow.city.presenter.SelectedCityFragmentPresenter
import com.inpows.weapow.city.presenter.SelectedCityContract
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ChangeCityModules, v 0.1 24/04/22 20.26 by Fauhan Handay Pugar
 */
@Module
class SelectedCityModules constructor(private val view: SelectedCityContract.View) {

    @Provides
    @PerActivity
    fun provideViewSelectedCity(): SelectedCityContract.View = view

    @Provides
    @PerActivity
    fun providePresenterSelectedCity(presenter: SelectedCityFragmentPresenter): SelectedCityContract.Presenter = presenter

    @Provides
    @Singleton
    fun provideCoroutineContextSelectedCity(): CoroutineContext = Dispatchers.Default

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcherSelectedCity(): CoroutineDispatcher = Dispatchers.Default
}