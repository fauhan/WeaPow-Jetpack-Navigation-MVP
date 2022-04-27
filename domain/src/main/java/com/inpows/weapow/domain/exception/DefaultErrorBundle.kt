package com.inpows.weapow.domain.exception


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version DefaultErrorBundle, v 0.1 20/04/22 11.51 by Fauhan Handay Pugar
 */
class DefaultErrorBundle(private val exception: Exception?) : ErrorBundle {
    override fun getException(): Exception? {
        return exception
    }

    override fun getErrorMessage(): String? {
        return if (exception != null) exception.message else DEFAULT_ERROR_MSG
    }

    companion object {
        private const val DEFAULT_ERROR_MSG = "Unknown error"
    }

}