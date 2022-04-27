package com.inpows.weapow.di


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version HasComponent, v 0.1 22/04/22 02.13 by Fauhan Handay Pugar
 */
interface HasComponent<C> {
    fun getComponent(): C
}