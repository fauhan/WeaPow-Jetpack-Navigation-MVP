package com.inpows.weapow.di.modules

import com.inpows.weapow.di.PerActivity
import com.inpows.weapow.domain.DefaultDispatcher
import com.inpows.weapow.dashboard.presenter.DashboardActivityPresenter
import com.inpows.weapow.dashboard.presenter.WeatherInfoContract
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class DashboardModule constructor(private var view: WeatherInfoContract.View) {

    @Provides
    @PerActivity
    fun provideView(): WeatherInfoContract.View = view

    @Provides
    @PerActivity
    fun providePresenter(dashboardPresenter: DashboardActivityPresenter): WeatherInfoContract.Presenter = dashboardPresenter


    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.Default

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}