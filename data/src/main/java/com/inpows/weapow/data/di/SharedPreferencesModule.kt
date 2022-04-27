package com.inpows.weapow.data.di

import android.content.Context
import com.inpows.weapow.data.service.local.SharedPrefs
import com.inpows.weapow.data.city.source.LocalChangeCityEntityData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version SharedPreferencesModule, v 0.1 24/04/22 19.46 by Fauhan Handay Pugar
 */
@Module
object SharedPreferencesModule {

    @Singleton
    @Provides
    fun provideShredPreferences(context: Context) = SharedPrefs(context)

    @Singleton
    @Provides
    fun provideSharedPreferencesEntityData(sharedPrefs: SharedPrefs) = LocalChangeCityEntityData(sharedPrefs)

}