package com.inpows.weapow.dashboard.presenter

import com.inpows.weapow.base.AbstractContractKt
import com.inpows.weapow.domain.dashboard.model.WeatherRootDomain

interface WeatherInfoContract {
    interface View : AbstractContractKt.AbstractView {
        fun onSuccessGetCityLocal(cityId: String)
        fun onErrorGetCityLocal()
        fun onSuccessGetWeatherInfo(weatherRootDomain: WeatherRootDomain)
        fun onErrorGetWeatherInfo()
    }

    interface Presenter : AbstractContractKt.AbstractPresenter {

        fun loadCityLocal()

        fun getWeatherInfoByCityId(cityId: String)

        fun cancel()
    }
}