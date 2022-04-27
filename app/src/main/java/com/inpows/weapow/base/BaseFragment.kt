package com.inpows.weapow.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.inpows.weapow.di.component.ApplicationComponent


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version BaseFragment, v 0.1 24/04/22 12.37 by Fauhan Handay Pugar
 */

abstract class BaseFragment: Fragment(), PresenterHandler {

    private var baseActivity: BaseActivity? = null
    private var presenterList: ArrayList<AbstractContract.AbstractPresenter>? = null

    protected abstract fun init()

    override fun registerPresenter(vararg presenters: AbstractContract.AbstractPresenter?) {
        if (presenterList == null) {
            presenterList = ArrayList()
        }

        presenters.let { presentersList ->
            ArrayList<Int>(presentersList.size).apply {
                presentersList.forEach {
                    if (it != null) {
                        presenterList?.add(it)
                    }
                }
            }
        }
    }

    override fun disposePresenter() {
        if (presenterList != null) {
            for (presenter in presenterList!!) {
                presenter.onDestroy()
            }
            presenterList = null
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposePresenter()
    }

    /**
     * get [BaseActivity]
     */
    open fun getBaseActivity(): BaseActivity? {
        return baseActivity
    }

    /**
     * get [ApplicationComponent]
     */
    open fun getApplicationComponent(): ApplicationComponent? {
        return if (getBaseActivity() != null) {
            getBaseActivity()?.getApplicationComponent()
        } else null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(activity is BaseActivity){
            baseActivity = activity as BaseActivity?
        }
    }
}