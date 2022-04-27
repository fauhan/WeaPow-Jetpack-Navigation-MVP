package com.inpows.weapow.di.component

import com.inpows.weapow.di.PerActivity
import com.inpows.weapow.di.modules.DashboardModule
import com.inpows.weapow.dashboard.DashboardFragment
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [DashboardModule::class])
interface DashboardComponent {
    fun inject(dashboardFragment: DashboardFragment)
}