package com.inpows.weapow.di

import com.inpows.weapow.di.component.ApplicationComponent


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ComponentHolder, v 0.1 22/04/22 02.14 by Fauhan Handay Pugar
 */
class ComponentHolder(private var applicationComponent: ApplicationComponent) {
    private var componentHolder: ComponentHolder? = null

    fun set(applicationComponent: ApplicationComponent) {
        if (componentHolder == null) {
            componentHolder = ComponentHolder(applicationComponent)
        }
    }

    fun provide(): ApplicationComponent {
        checkNotNull(componentHolder) { "Application components needs to be set in Application" }
        return componentHolder!!.applicationComponent
    }
}