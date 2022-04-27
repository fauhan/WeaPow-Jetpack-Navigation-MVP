package com.inpows.weapow.city.presenter

import com.inpows.weapow.base.AbstractContract
import com.inpows.weapow.base.AbstractContractKt


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version SearchCityContract, v 0.1 24/04/22 09.51 by Fauhan Handay Pugar
 */
interface SelectedCityContract {
    interface View : AbstractContractKt.AbstractView {
        fun onSuccessSaveCityLocal(cityId: String)
        fun onErrorSaveCityLocal()
        fun onSuccessGetCityLocal(cityId: String)
        fun onErrorGetCityLocal()
    }

    interface Presenter : AbstractContract.AbstractPresenter {

        fun saveCityLocal(cityId: String)

        fun loadCityLocal()

        fun cancel()
    }
}