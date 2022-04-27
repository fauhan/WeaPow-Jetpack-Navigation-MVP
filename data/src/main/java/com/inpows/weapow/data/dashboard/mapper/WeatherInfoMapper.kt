package com.inpows.weapow.data.dashboard.mapper

import com.inpows.weapow.data.dashboard.model.weather.WeatherRootDto
import com.inpows.weapow.domain.dashboard.model.*
import com.inpows.weapow.domain.dashboard.model.WeatherRootDomain

fun WeatherRootDto.toWeatherInfo() = WeatherRootDomain(
    coord = CoordinateDomain(
        lon = this.coord?.lon ?: 0.0,
        lat = this.coord?.lat ?: 0.0
    ),
    weather = this.weatherDto.map { weather ->
        Weather(
            id = weather.id,
            main = weather.main,
            description = weather.description,
            icon = weather.icon
        )
    },
    base = this.base,
    mainDomain = MainDomain(
        temp = this.mainDto?.temp ?: 0.0,
        feelsLike = this.mainDto?.feelsLike ?: 0.0,
        tempMin = this.mainDto?.tempMin ?: 0.0,
        tempMax = this.mainDto?.tempMax ?: 0.0,
        pressure = this.mainDto?.pressure ?: 0,
        humidity = this.mainDto?.humidity ?: 0
    ),
    visibility = this.visibility,
    wind = Wind(
        speed = this.windDto?.speed ?: 0.0,
        deg = this.windDto?.deg ?: 0
    ),
    cloudsDomain = CloudsDomain(
        all = this.cloudsDto?.all ?: 0
    ),
    dt = this.dt,
    sys = Sys(
        type = this.sysDto?.type ?: 0,
        id = this.sysDto?.id ?: 0,
        country = this.sysDto?.country ?: "",
        sunrise = this.sysDto?.sunrise ?: 0,
        sunset = this.sysDto?.sunset ?: 0
    ),
    timezone = this.timezone,
    id = this.id,
    name = this.name,
    cod = this.cod
)