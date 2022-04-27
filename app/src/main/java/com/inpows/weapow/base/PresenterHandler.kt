package com.inpows.weapow.base


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version PresenterHandler, v 0.1 22/04/22 04.01 by Fauhan Handay Pugar
 */
interface PresenterHandler {

    fun registerPresenter(vararg presenters: AbstractContract.AbstractPresenter?)

    fun disposePresenter()
}