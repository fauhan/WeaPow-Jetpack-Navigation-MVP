package com.inpows.weapow.data.common.utils


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ConnectionListener, v 0.1 25/04/22 12.29 by Fauhan Handay Pugar
 */
/**
 * A listener used to specify the actions to perform on Internet connection online/offline.
 */
class ConnectionListener @PublishedApi internal constructor() {

    @PublishedApi
    internal var offline: () -> Unit = {}
    @PublishedApi
    internal var online: () -> Unit = {}

    /**
     * Block to run on Internet connection offline.
     */
    fun offline(offline: () -> Unit) {
        this.offline = offline
    }

    /**
     * Block to run on Internet connection online.
     */
    fun online(online: () -> Unit) {
        this.online = online
    }
}