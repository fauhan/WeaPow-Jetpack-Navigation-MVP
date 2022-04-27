package com.inpows.weapow.data

import androidx.annotation.StringDef

@StringDef(Source.LOCAL, Source.NETWORK)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class Source {
    companion object {
        const val LOCAL = "local"
        const val NETWORK = "network"
    }
}
