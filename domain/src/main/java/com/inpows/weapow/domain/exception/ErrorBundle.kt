package com.inpows.weapow.domain.exception


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ErrorBundle, v 0.1 20/04/22 11.51 by Fauhan Handay Pugar
 */
interface ErrorBundle {
    fun getException(): Exception?
    fun getErrorMessage(): String?
}