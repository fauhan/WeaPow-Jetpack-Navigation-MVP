package com.inpows.weapow.dashboard.presenter

import com.inpows.weapow.di.PerActivity
import com.inpows.weapow.domain.dashboard.interactor.GetWeatherInfoInteractor
import com.inpows.weapow.domain.city.interactor.LoadCityInteractor
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@PerActivity
class DashboardActivityPresenter @Inject constructor(
    private val view: WeatherInfoContract.View,
    private val getWeatherInfoInteractor: GetWeatherInfoInteractor,
    private val loadCityInteractor: LoadCityInteractor
) : WeatherInfoContract.Presenter, CoroutineScope {

    private val mainJob = SupervisorJob()
    override val coroutineContext: CoroutineContext = mainJob

    override fun loadCityLocal() {
        MainScope().launch {
            withContext(Dispatchers.Main) {
                view.showProgress()
                loadCityInteractor.invoke(
                    params = Unit,
                    onSuccess = {
                        view.dismissProgress()
                        view.onSuccessGetCityLocal(it)
                    },
                    onError = {
                        view.dismissProgress()
                        view.onErrorGetCityLocal()
                    }
                )
            }
        }
    }

    override fun getWeatherInfoByCityId(cityId: String) {
        MainScope().launch {
            withContext(Dispatchers.Main) {
                view.showProgress()
                getWeatherInfoInteractor.invoke(
                    params = GetWeatherInfoInteractor.Params(cityId),
                    onSuccess = {
                        view.dismissProgress()
                        view.onSuccessGetWeatherInfo(it)
                    },
                    onError = {
                        view.dismissProgress()
                        view.onErrorGetWeatherInfo()
                    }
                )
            }
        }
    }

    override fun cancel() {
        mainJob.cancel()
    }

    override fun onDestroy() {
        mainJob.cancel()
    }
}