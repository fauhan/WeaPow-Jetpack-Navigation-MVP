package com.inpows.weapow

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.inpows.weapow.data.di.ApiModule
import com.inpows.weapow.di.ComponentHolder
import com.inpows.weapow.di.component.ApplicationComponent
import com.inpows.weapow.di.component.DaggerApplicationComponent
import com.inpows.weapow.di.modules.ApplicationModules
import timber.log.Timber
import timber.log.Timber.*


class MVPApp : MultiDexApplication() {

    private var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        initInjector()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    private fun initInjector() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModules(ApplicationModules(this@MVPApp))
                .apiModule(ApiModule)
                .build()
        }
        applicationComponent?.inject(this)
        applicationComponent?.let { ComponentHolder(it).set(it) }
    }


    fun getApplicationComponent(): ApplicationComponent? {
        return applicationComponent
    }
}