package com.inpows.weapow.di.component

import com.inpows.weapow.base.BaseActivity
import com.inpows.weapow.di.PerActivity
import com.inpows.weapow.di.modules.ActivityModule
import dagger.Component


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ActivityComponent, v 0.1 21/04/22 10.52 by Fauhan Handay Pugar
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): BaseActivity
}