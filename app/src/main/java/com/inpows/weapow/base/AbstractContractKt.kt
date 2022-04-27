package com.inpows.weapow.base

interface AbstractContractKt : AbstractContract {

    interface AbstractView : AbstractContract.AbstractView {
        override fun showProgress() {
            /* default implementation */
        }

        override fun dismissProgress() {
            /* default implementation */
        }

        override fun onError(errorMessage: String?) {
            /* default implementation */
        }
    }

    interface AbstractPresenter : AbstractContract.AbstractPresenter {
        override fun onDestroy() {
            /* default implementation */
        }
    }
}