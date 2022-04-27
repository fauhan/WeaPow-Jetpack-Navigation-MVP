package com.inpows.weapow.data

import com.inpows.weapow.data.dashboard.model.CoordinateDto
import com.inpows.weapow.data.dashboard.model.WeatherDto
import com.inpows.weapow.data.dashboard.model.weather.*
import com.inpows.weapow.data.dashboard.mapper.toWeatherInfo
import com.inpows.weapow.domain.dashboard.model.CloudsDomain
import com.inpows.weapow.domain.dashboard.model.CoordinateDomain
import com.inpows.weapow.domain.dashboard.model.MainDomain
import com.inpows.weapow.domain.dashboard.model.WeatherRootDomain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version WeatherInfoMapperTest, v 0.1 22/04/22 14.52 by Fauhan Handay Pugar
 */
class WeatherDtoInfoMapperTest {

    companion object {
        const val STATIC_CLOUDS_ALL = 0
        const val STATIC_MAIN_TEMP = 33.8
        const val STATIC_MAIN_FEELS_LIKE = 31.4
        const val STATIC_MAIN_TEMP_MIN = 30.3
        const val STATIC_MAIN_TEMP_MAX = 36.3
        const val STATIC_MAIN_PRESSURE = 1001
        const val STATIC_MAIN_HUMIDITY = 60
        const val STATIC_COORDINATE_LON = 41.5
        const val STATIC_COORDINATE_LAT = 41.5
        const val STATIC_WEATHER_ID = 1
        const val STATIC_WEATHER_MAIN = "Clouds"
        const val STATIC_WEATHER_DESCRIPTION = "overcast clouds"
        const val STATIC_WEATHER_ICON = "04n"
        const val STATIC_BASE = "stations"
        const val STATIC_VISIBILITY = 10000
        const val STATIC_WIND_SPEED = 0.74
        const val STATIC_WIND_DEG = 93
        const val STATIC_DT = 1649758937
        const val STATIC_SYS_TYPE = 1
        const val STATIC_SYS_ID = 9325
        const val STATIC_SYS_COUNTRY = "ID"
        const val STATIC_SYS_SUNRISE = 1649714419
        const val STATIC_SYS_SUNSET = 1649757663
        const val STATIC_TIMEZONE = 28800
        const val STATIC_ID = 1643084
        const val STATIC_NAME = "Indonesia"
        const val STATIC_COD = 200
    }

    @Mock
    private lateinit var weatherRootDto: WeatherRootDto

    @Mock
    private lateinit var weatherRootDomain: WeatherRootDomain

    @Mock
    private lateinit var cloudsDto: CloudsDto

    @Mock
    private lateinit var cloudsDomain: CloudsDomain

    @Mock
    private lateinit var mainDto: MainDto

    @Mock
    private lateinit var mainDomain: MainDomain

    @Mock
    private lateinit var coordinateDto: CoordinateDto

    @Mock
    private lateinit var coordinateDomain: CoordinateDomain

    @Before
    fun setUp() {
        weatherRootDto = spy(WeatherRootDto::class.java)
        weatherRootDomain = mock(WeatherRootDomain::class.java)
        cloudsDto = spy(CloudsDto::class.java)
        cloudsDomain = mock(CloudsDomain::class.java)
        mainDto = spy(MainDto::class.java)
        mainDomain = mock(MainDomain::class.java)
        coordinateDto = spy(CoordinateDto::class.java)
        coordinateDomain = mock(CoordinateDomain::class.java)
    }

    @Test
    fun transformCloudsDtoToCloudsDomain() {
        Mockito.`when`(cloudsDto.all).thenReturn(STATIC_CLOUDS_ALL)
        assertEquals(
            cloudsDto.all,
            STATIC_CLOUDS_ALL
        )
    }

    @Test
    fun transformMainDtoToMainDomain() {
        Mockito.`when`(mainDto.temp).thenReturn(STATIC_MAIN_TEMP)
        Mockito.`when`(mainDto.feelsLike).thenReturn(STATIC_MAIN_FEELS_LIKE)
        Mockito.`when`(mainDto.tempMin).thenReturn(STATIC_MAIN_TEMP_MIN)
        Mockito.`when`(mainDto.tempMax).thenReturn(STATIC_MAIN_TEMP_MAX)
        Mockito.`when`(mainDto.pressure).thenReturn(STATIC_MAIN_PRESSURE)
        Mockito.`when`(mainDto.humidity).thenReturn(STATIC_MAIN_HUMIDITY)
        assertEquals(mainDto.temp.toString(), STATIC_MAIN_TEMP.toString())
        assertEquals(mainDto.feelsLike.toString(), STATIC_MAIN_FEELS_LIKE.toString())
        assertEquals(mainDto.tempMin.toString(), STATIC_MAIN_TEMP_MIN.toString())
        assertEquals(mainDto.tempMax.toString(), STATIC_MAIN_TEMP_MAX.toString())
        assertEquals(mainDto.pressure, STATIC_MAIN_PRESSURE)
        assertEquals(mainDto.humidity, STATIC_MAIN_HUMIDITY)
    }

    @Test
    fun transformCoordinateDtoToCoordinateDomain() {
        Mockito.`when`(coordinateDto.lon).thenReturn(STATIC_COORDINATE_LON)
        Mockito.`when`(coordinateDto.lat).thenReturn(STATIC_COORDINATE_LAT)
        assertEquals(coordinateDto.lon.toString(), STATIC_COORDINATE_LON.toString())
        assertEquals(coordinateDto.lat.toString(), STATIC_COORDINATE_LAT.toString())
    }

    @Test fun transformWeatherRootMapper() {
        Mockito.`when`(weatherRootDto.coord).thenReturn(
            CoordinateDto(
                lon = STATIC_COORDINATE_LON,
                lat = STATIC_COORDINATE_LAT
            )
        )
        Mockito.`when`(weatherRootDto.weatherDto).thenReturn(listOf(
            WeatherDto(
            id = STATIC_WEATHER_ID,
            main = STATIC_WEATHER_MAIN,
            description = STATIC_WEATHER_DESCRIPTION,
            icon = STATIC_WEATHER_ICON
        )
        ))
        Mockito.`when`(weatherRootDto.base).thenReturn(STATIC_BASE)
        Mockito.`when`(weatherRootDto.mainDto).thenReturn(
            MainDto(
                temp = STATIC_MAIN_TEMP,
                feelsLike = STATIC_MAIN_FEELS_LIKE,
                tempMin = STATIC_MAIN_TEMP_MIN,
                tempMax = STATIC_MAIN_TEMP_MAX,
                humidity = STATIC_MAIN_HUMIDITY,
                pressure = STATIC_MAIN_PRESSURE
            )
        )
        Mockito.`when`(weatherRootDto.visibility).thenReturn(STATIC_VISIBILITY)
        Mockito.`when`(weatherRootDto.windDto).thenReturn(
            WindDto(
                speed = STATIC_WIND_SPEED,
                deg = STATIC_WIND_DEG
            )
        )
        Mockito.`when`(weatherRootDto.cloudsDto).thenReturn(
            CloudsDto(
                all = STATIC_CLOUDS_ALL
            )
        )
        Mockito.`when`(weatherRootDto.dt).thenReturn(STATIC_DT.toLong())
        Mockito.`when`(weatherRootDto.sysDto).thenReturn(
            SysDto(
                type = STATIC_SYS_TYPE,
                id = STATIC_SYS_ID,
                country = STATIC_SYS_COUNTRY,
                sunrise = STATIC_SYS_SUNRISE,
                sunset = STATIC_SYS_SUNSET
            )
        )
        Mockito.`when`(weatherRootDto.timezone).thenReturn(STATIC_TIMEZONE)
        Mockito.`when`(weatherRootDto.id).thenReturn(STATIC_ID)
        Mockito.`when`(weatherRootDto.name).thenReturn(STATIC_NAME)
        Mockito.`when`(weatherRootDto.cod).thenReturn(STATIC_COD)
        weatherRootDomain = weatherRootDto.toWeatherInfo()
        assertEquals(weatherRootDomain.coord?.lon.toString(),STATIC_COORDINATE_LON.toString())
        assertEquals(weatherRootDomain.coord?.lat.toString(),STATIC_COORDINATE_LAT.toString())
        assertEquals(weatherRootDomain.weather[0].id, STATIC_WEATHER_ID)
        assertEquals(weatherRootDomain.weather[0].main, STATIC_WEATHER_MAIN)
        assertEquals(weatherRootDomain.weather[0].description, STATIC_WEATHER_DESCRIPTION)
        assertEquals(weatherRootDomain.weather[0].icon, STATIC_WEATHER_ICON)
        assertEquals(weatherRootDomain.base, STATIC_BASE)
        assertEquals(weatherRootDomain.mainDomain?.temp, STATIC_MAIN_TEMP)
        assertEquals(weatherRootDomain.mainDomain?.feelsLike, STATIC_MAIN_FEELS_LIKE)
        assertEquals(weatherRootDomain.mainDomain?.tempMin, STATIC_MAIN_TEMP_MIN)
        assertEquals(weatherRootDomain.mainDomain?.tempMax, STATIC_MAIN_TEMP_MAX)
        assertEquals(weatherRootDomain.mainDomain?.humidity, STATIC_MAIN_HUMIDITY)
        assertEquals(weatherRootDomain.mainDomain?.pressure, STATIC_MAIN_PRESSURE)
        assertEquals(weatherRootDomain.visibility, STATIC_VISIBILITY)
        assertEquals(weatherRootDomain.wind?.speed, STATIC_WIND_SPEED)
        assertEquals(weatherRootDomain.wind?.deg, STATIC_WIND_DEG)
        assertEquals(weatherRootDomain.cloudsDomain?.all, STATIC_CLOUDS_ALL)
        assertEquals(weatherRootDomain.dt, STATIC_DT.toLong())
        assertEquals(weatherRootDomain.sys?.type, STATIC_SYS_TYPE)
        assertEquals(weatherRootDomain.sys?.id, STATIC_SYS_ID)
        assertEquals(weatherRootDomain.sys?.country, STATIC_SYS_COUNTRY)
        assertEquals(weatherRootDomain.sys?.sunrise, STATIC_SYS_SUNRISE)
        assertEquals(weatherRootDomain.sys?.sunset, STATIC_SYS_SUNSET)
        assertEquals(weatherRootDomain.timezone, STATIC_TIMEZONE)
        assertEquals(weatherRootDomain.id, STATIC_ID)
        assertEquals(weatherRootDomain.name, STATIC_NAME)
        assertEquals(weatherRootDomain.cod, STATIC_COD)
        assertEquals(weatherRootDomain.cod, STATIC_COD)
        assertEquals(weatherRootDomain.cod, STATIC_COD)
    }
}