package com.inpows.weapow.domain.core.usecase

typealias OnSuccessCallback<T> = (T) -> Unit

typealias OnErrorCallback = (Throwable) -> Unit

typealias OnCompleteCallback = () -> Unit

typealias OnCancelCallback = () -> Unit