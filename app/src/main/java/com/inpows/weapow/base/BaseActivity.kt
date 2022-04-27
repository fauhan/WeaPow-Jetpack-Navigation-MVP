package com.inpows.weapow.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inpows.weapow.di.component.ApplicationComponent
import com.inpows.weapow.MVPApp

abstract class BaseActivity: AppCompatActivity(), PresenterHandler {

    private var presenterList: ArrayList<AbstractContract.AbstractPresenter>? = null
    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
    }

    open fun init(savedInstanceState: Bundle?) {
        getApplicationComponent()?.inject(this)
        init()
    }

    open fun getApplicationComponent(): ApplicationComponent? {
        return (application as MVPApp).getApplicationComponent()
    }

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
        presenterList?.let {
            for (presenter in it) {
                presenter.onDestroy()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposePresenter()
    }

}