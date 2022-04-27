package com.inpows.weapow.di.component

import android.app.Application
import android.content.Context
import com.inpows.weapow.base.BaseActivity
import com.inpows.weapow.data.di.ApiModule
import com.inpows.weapow.di.modules.ApplicationModules
import com.inpows.weapow.domain.executor.ThreadExecutor
import com.inpows.weapow.domain.city.repository.CityRepository
import com.inpows.weapow.domain.dashboard.repository.WeatherInfoRepository
import com.inpows.weapow.MVPApp
import dagger.Component
import javax.inject.Singleton


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ApplicationComponent, v 0.1 21/04/22 09.03 by Fauhan Handay Pugar
 */

@Singleton
@Component(modules = [
    ApplicationModules::class,
    ApiModule::class
])
interface ApplicationComponent {

    fun inject(mvpApp: MVPApp)

    fun inject(baseActivity: BaseActivity)

    fun context(): Context

    fun application(): Application

    fun threadExecutor(): ThreadExecutor

//    fun postExecutionThread(): PostExecutionThread

    fun weatherInfoRepository(): WeatherInfoRepository

    fun changeCityRepository(): CityRepository
}