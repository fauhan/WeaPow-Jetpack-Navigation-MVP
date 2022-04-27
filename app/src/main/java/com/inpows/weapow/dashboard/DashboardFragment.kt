package com.inpows.weapow.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.inpows.weapow.R
import com.inpows.weapow.base.BaseFragment
import com.inpows.weapow.core.const.WeatherTypes
import com.inpows.weapow.dashboard.adapter.WeatherDetailAdapter
import com.inpows.weapow.dashboard.presenter.WeatherInfoContract
import com.inpows.weapow.dashboard.utils.DateConverter
import com.inpows.weapow.data.common.utils.runOnConnection
import com.inpows.weapow.data.core.SampleData
import com.inpows.weapow.data.dashboard.model.weather.WeatherItem
import com.inpows.weapow.databinding.FragmentDashboardBinding
import com.inpows.weapow.di.component.DaggerDashboardComponent
import com.inpows.weapow.di.component.DashboardComponent
import com.inpows.weapow.di.modules.DashboardModule
import com.inpows.weapow.domain.dashboard.model.WeatherRootDomain
import timber.log.Timber
import javax.inject.Inject


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version DashboardFragment, v 0.1 27/04/22 20.47 by Fauhan Handay Pugar
 */
class DashboardFragment: BaseFragment(), WeatherInfoContract.View {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private var dashboardComponent: DashboardComponent? = null

    @Inject
    lateinit var presenter: WeatherInfoContract.Presenter
    private lateinit var weatherDetailAdapter: WeatherDetailAdapter
    private lateinit var weatherItemList : List<WeatherItem>
    private lateinit var pulseAnim: Animation
    private lateinit var fadeInAnim: Animation
    private lateinit var lottieAnimationViewWeather: LottieAnimationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun init() {
        initInjector()
        loadAnimation()
        setupRecyclerView()
        setupClickView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadCityLocal()
    }

    override fun onResume() {
        super.onResume()
        presenter.loadCityLocal()
    }

    @Suppress("DEPRECATION")
    private fun initInjector() {
        if (dashboardComponent == null) {
            dashboardComponent = DaggerDashboardComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .dashboardModule(DashboardModule(this))
                .build()
        }
        dashboardComponent?.inject(this)
        registerPresenter(presenter)
    }

    private fun loadAnimation() {
        pulseAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.pulse)
        fadeInAnim = AnimationUtils.loadAnimation(requireContext(), androidx.appcompat.R.anim.abc_fade_in)
        binding.ivProfile.startAnimation(pulseAnim)
        binding.llcWeatherInformation.startAnimation(fadeInAnim)

        lottieAnimationViewWeather = binding.animationViewWeather
    }

    private fun setupRecyclerView() {
        weatherItemList = listOf()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.layoutManager = layoutManager
    }

    private fun setupClickView(){
        binding.llcSearchCity.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_cityFragment)
        }
    }

    private fun setWeatherAssetByType(iconType: String): String{
        return when (iconType) {
            WeatherTypes.CLEAR_SKY_DAY -> {
                "ic_sunny_01d.json"
            }
            WeatherTypes.CLEAR_SKY_NIGHT -> {
                "ic_moon_01n.json"
            }
            WeatherTypes.FEW_CLOUDS_DAY -> {
                "ic_few_clouds_02d.json"
            }
            WeatherTypes.FEW_CLOUDS_NIGHT -> {
                "ic_few_clouds_02n.json"
            }
            WeatherTypes.SCATTERED_CLOUD_DAY -> {
                "ic_scattered_clouds_03d.json"
            }
            WeatherTypes.SCATTERED_CLOUD_NIGHT -> {
                "ic_scattered_clouds_03n.json"
            }
            WeatherTypes.BROKEN_CLOUDS_DAY -> {
                "ic_broken_clouds_04d.json"
            }
            WeatherTypes.BROKEN_CLOUDS_NIGHT -> {
                "ic_broken_clouds_04n.json"
            }
            WeatherTypes.SHOWER_RAIN_DAY -> {
                "ic_shower_rain_09d.json"
            }
            WeatherTypes.SHOWER_RAIN_NIGHT -> {
                "ic_shower_rain_09n.json"
            }
            WeatherTypes.RAIN_DAY -> {
                "ic_rain_10d.json"
            }
            WeatherTypes.RAIN_NIGHT -> {
                "ic_rain_10n.json"
            }
            WeatherTypes.THUNDERSTORM_DAY-> {
                "ic_thunderstorm_11d.json"
            }
            WeatherTypes.THUNDERSTORM_NIGHT-> {
                "ic_thunderstorm_11n.json"
            }
            else -> {
                "ic_splash.json"
            }
        }
    }

    private fun loadListWeather(weatherRoot: WeatherRootDomain): List<WeatherItem>{
        return listOf(
            WeatherItem(
                resIcon = R.drawable.ic_sunrise,
                label = resources.getString(R.string.sunrise),
                value = DateConverter().convertLongToTime(
                    weatherRoot.sys?.sunrise?.toLong() ?: 0,
                    "GMT-07:00"
                )
            ),
            WeatherItem(
                resIcon = R.drawable.ic_sunset,
                label = resources.getString(R.string.sunset),
                value = DateConverter().convertLongToTime(
                    weatherRoot.sys?.sunset?.toLong() ?: 0,
                    "GMT+07:00"
                )
            ),
            WeatherItem(
                resIcon = R.drawable.ic_temperature_min,
                label = resources.getString(R.string.temp_min),
                value = resources.getString(
                    R.string.value_temperature,
                    weatherRoot.mainDomain?.tempMin.toString()
                )
            ),
            WeatherItem(
                resIcon = R.drawable.ic_temperature_max,
                label = resources.getString(R.string.temp_max),
                value = resources.getString(
                    R.string.value_temperature,
                    weatherRoot.mainDomain?.tempMax.toString()
                )
            ),
            WeatherItem(
                resIcon = R.drawable.ic_temperature_feels_like,
                label = resources.getString(R.string.temp_feels_like),
                value = resources.getString(
                    R.string.value_temperature,
                    weatherRoot.mainDomain?.feelsLike.toString()
                )
            ),
            WeatherItem(
                resIcon = R.drawable.ic_weather_pressure,
                label = resources.getString(R.string.pressure),
                value = weatherRoot.mainDomain?.pressure.toString()
            )
        )
    }

    override fun onSuccessGetCityLocal(cityId: String) {
        requireContext().runOnConnection {
            online {
                binding.ivConnectionFailed.visibility = View.GONE
                binding.llcTopBar.visibility = View.VISIBLE
                binding.animationViewWeather.visibility = View.VISIBLE
                binding.llcWeatherInformation.visibility = View.VISIBLE
                if(cityId != ""){
                    presenter.getWeatherInfoByCityId(cityId)
                    val cityObject = SampleData.listOfCity.filter { it.id == cityId }
                    binding.tvCurrentCountry.text = cityObject.first().name
                } else {
                    presenter.getWeatherInfoByCityId(SAVED_CITY_ID)
                    binding.tvCurrentCountry.text = COUNTRY_NAME
                }
            }
            offline {
                binding.ivConnectionFailed.visibility = View.VISIBLE
                binding.llcTopBar.visibility = View.GONE
                binding.animationViewWeather.visibility = View.GONE
                binding.llcWeatherInformation.visibility = View.GONE
                Timber.d("Anda Offline")
            }
        }
    }

    override fun onErrorGetCityLocal() {
        presenter.getWeatherInfoByCityId(SAVED_CITY_ID)
        binding.tvCurrentCountry.text = COUNTRY_NAME
    }

    override fun onSuccessGetWeatherInfo(weatherRootDomain: WeatherRootDomain) {
        binding.tvCurrentDate.text = resources.getString(R.string.value_current_date, DateConverter().convertLongToDate(weatherRootDomain.dt, weatherRootDomain.timezone.toString()))
        if(weatherRootDomain.weather.isNotEmpty()){
            lottieAnimationViewWeather.setAnimation(setWeatherAssetByType(weatherRootDomain.weather[0].icon))
        } else {
            lottieAnimationViewWeather.setAnimation("ic_splash.json")
        }
        binding.tvWindValue.text = weatherRootDomain.wind?.speed.toString()
        binding.tvHumidityValue.text = weatherRootDomain.mainDomain?.humidity.toString()
        binding.tvTemperatureValue.text = resources.getString(R.string.value_temperature, weatherRootDomain.mainDomain?.temp.toString())
        weatherItemList = loadListWeather(weatherRootDomain)
        weatherDetailAdapter = WeatherDetailAdapter(weatherItemList)
        binding.recyclerview.adapter = weatherDetailAdapter
    }

    override fun onErrorGetWeatherInfo() {
        Timber.e("Failed hit service")
    }

    companion object {
        const val EXTRA_MESSAGE_SAVED_CITY_ID = "com.inpows.weapow.searchCity.cityId"
        const val SAVED_CITY_ID = "1646170"
        const val COUNTRY_NAME = "Cirebon"
    }
}