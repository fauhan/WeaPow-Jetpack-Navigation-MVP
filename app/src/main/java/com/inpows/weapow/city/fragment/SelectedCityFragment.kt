package com.inpows.weapow.city.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.inpows.weapow.base.BaseFragment
import com.inpows.weapow.data.core.SampleData
import com.inpows.weapow.databinding.FragmentSelectedCityBinding
import com.inpows.weapow.di.component.DaggerSelectedCityComponent
import com.inpows.weapow.di.component.SelectedCityComponent
import com.inpows.weapow.di.modules.SelectedCityModules
import com.inpows.weapow.city.presenter.SelectedCityContract
import com.inpows.weapow.city.adapter.CityAdapter
import com.inpows.weapow.city.listener.CityRVClickListener
import javax.inject.Inject


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version SelectedCityFragment, v 0.1 24/04/22 12.30 by Fauhan Handay Pugar
 */
class SelectedCityFragment: BaseFragment(), SelectedCityContract.View, CityRVClickListener {

    private var _binding: FragmentSelectedCityBinding? = null
    private val binding get() = _binding!!
    private var selectedCityComponent: SelectedCityComponent? = null

    @Inject
    lateinit var presenter: SelectedCityContract.Presenter
    private lateinit var selectedCity: String
    private lateinit var adapterCity: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectedCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun init() {
        initInjector()
        presenter.loadCityLocal()
        setupRecyclerView()
    }

    @Suppress("DEPRECATION")
    private fun initInjector() {
        if(selectedCityComponent == null){
            selectedCityComponent = DaggerSelectedCityComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .selectedCityModules(SelectedCityModules(this))
                .build()
        }
        selectedCityComponent?.inject(this)
        registerPresenter(presenter)
    }

    private fun setupRecyclerView(){
        binding.rvCity.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCity.overScrollMode = View.OVER_SCROLL_NEVER
        adapterCity = CityAdapter(SampleData.listOfCity)
        adapterCity.listener = this
        binding.rvCity.adapter = adapterCity
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSuccessSaveCityLocal(cityId: String) {
        val cityObject = SampleData.listOfCity.filter { it.id == cityId }
        selectedCity = cityObject.first().name
        binding.tvSelectedCity.text = selectedCity
    }

    override fun onErrorSaveCityLocal() {
        binding.tvSelectedCity.text = selectedCity
    }

    override fun onSuccessGetCityLocal(cityId: String) {
        val cityObject = SampleData.listOfCity.filter { it.id == cityId }
        selectedCity = cityObject.first().name
        binding.tvSelectedCity.text = selectedCity
    }

    override fun onErrorGetCityLocal() {
//        binding.tvSelectedCity.text = "-"
//        selectedCity = "-"
    }

    override fun onItemClicked(view: View, cityId: String) {
        presenter.saveCityLocal(cityId)
    }

}