package com.inpows.weapow.domain

import javax.inject.Qualifier


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version DispatcherQualifiers, v 0.1 21/04/22 03.39 by Fauhan Handay Pugar
 */

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher