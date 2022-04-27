package com.inpows.weapow.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.inpows.weapow.data.BuildConfig
import com.inpows.weapow.data.service.network.WeatherAPI
import com.inpows.weapow.data.dashboard.source.NetworkWeatherInfoEntityData
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object ApiModule{
    // Weather
    //http://api.openweathermap.org/data/2.5/weather?q=toshkent&units=metric&appid=5849aae41830e75a76a36dab467ade51
    private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

    //Forecast
    //http://api.openweathermap.org/data/2.5/forecast/daily?lat={lat}&lon={lon}&cnt={cnt}&appid={API key}

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .disableHtmlEscaping()
            .setDateFormat(DateFormat.LONG)
            .create()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.HEADERS else HttpLoggingInterceptor.Level.NONE
        loggingInterceptor.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        httpBuilder
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .retryOnConnectionFailure(false)
            .addInterceptor(httpLoggingInterceptor)
            .followRedirects(true)
            .cache(null)
        return httpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherAPI(): WeatherAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    @Singleton
    @Provides
    fun provideNetworkEntityData(weatherAPI: WeatherAPI) = NetworkWeatherInfoEntityData(weatherAPI)

}