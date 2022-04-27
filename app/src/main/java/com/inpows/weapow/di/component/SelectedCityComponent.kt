package com.inpows.weapow.di.component

import com.inpows.weapow.di.PerActivity
import com.inpows.weapow.di.modules.SelectedCityModules
import com.inpows.weapow.city.fragment.SelectedCityFragment
import dagger.Component


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version SelectedCityComponent, v 0.1 24/04/22 20.25 by Fauhan Handay Pugar
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [SelectedCityModules::class])
interface SelectedCityComponent {
    fun inject(selectedCityFragment: SelectedCityFragment)
}