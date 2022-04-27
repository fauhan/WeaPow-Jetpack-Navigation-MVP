package com.inpows.weapow.base

interface AbstractContract {

    interface AbstractView {
        fun showProgress()
        fun dismissProgress()
        fun onError(errorMessage: String?)
    }

    interface AbstractPresenter {
        fun onDestroy()
    }
}