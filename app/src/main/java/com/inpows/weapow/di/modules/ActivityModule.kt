package com.inpows.weapow.di.modules

import com.inpows.weapow.base.BaseActivity
import com.inpows.weapow.di.PerActivity
import dagger.Module
import dagger.Provides


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ActivityModule, v 0.1 21/04/22 10.51 by Fauhan Handay Pugar
 */
@Module
class ActivityModule constructor(private var baseActivity: BaseActivity) {

    @Provides
    @PerActivity
    fun activity(): BaseActivity = baseActivity

}