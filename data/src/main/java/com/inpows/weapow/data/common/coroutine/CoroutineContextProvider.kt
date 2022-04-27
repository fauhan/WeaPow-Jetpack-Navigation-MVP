package com.inpows.weapow.data.common.coroutine

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class CoroutineContextProvider {
    open val io: CoroutineContext by lazy { Dispatchers.IO }
    open val main: CoroutineContext by lazy { Dispatchers.Unconfined }
    open val default: CoroutineContext by lazy { Dispatchers.Default }
}