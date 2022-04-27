package com.inpows.weapow.data.common.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version NetworkExtensions, v 0.1 25/04/22 12.30 by Fauhan Handay Pugar
 */

/**
 * Returns true if the internet connection is on, false otherwise.
 *
 * @return true if the internet connection is on, false otherwise.
 */
fun Context.isInternetConnectionOn(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetwork =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    } else {
        connectivityManager.run {
            @Suppress("DEPRECATION")
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }

            }
        }
    }

    return false
}

/**
 * Runs one of the given blocks based on whether Internet connection is on/off.
 *
 * @param builder a lambda specifying the blocks to execute based on Internet connectivity
 */
inline fun Context.runOnConnection(crossinline builder: ConnectionListener.() -> Unit) {
    val listener = ConnectionListener().apply(builder)
    if (!isInternetConnectionOn()) {
        listener.offline()
    } else {
        listener.online()
    }
}

/**
 * Runs the given block only if the Internet connection is on.
 *
 * @param block the block to execute if the connection is on
 */
inline fun Context.runIfConnected(crossinline block: () -> Unit) {
    if (isInternetConnectionOn()) {
        block()
    }
}

/**
 * Runs the given block only if the Internet connection is off.
 *
 * @param block the block to execute if the connection is off
 */
inline fun Context.runIfDisconnected(crossinline block: () -> Unit) {
    if (!isInternetConnectionOn()) {
        block()
    }
}