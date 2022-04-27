package com.inpows.weapow.domain.core.usecase

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import timber.log.Timber

abstract class BaseUseCase<T, Params> {
    private val disposable = CompositeDisposable()

    abstract fun buildUseCase(params: Params): Observable<T>

    @JvmOverloads
    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {}
    ) {
        execute(params, onSuccess, onError, null, { })
    }

    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback = {}
    ) {
        execute(params, onSuccess, onError, onComplete, { })
    }

    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback? = {},
        onDispose: Action = Action { }
    ) {
        print("test")
        buildUseCase(params)
            .subscribeOn(UseCaseSchedulers.jobScheduler)
            .observeOn(UseCaseSchedulers.postScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
            }, {
                Timber.e(it, getSubclassPath())
                onError(it)
                dispose()
            }, {
                onComplete?.invoke()
                dispose()
            })
            .let { disposable.add(it) }
    }

    private fun getSubclassPath(): String =
        this.javaClass.asSubclass(this.javaClass).name ?: "Unknown"

    @JvmOverloads
    fun executeInBackground(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {}
    ) {
        executeInBackground(params, onSuccess, onError, null, { })
    }

    fun executeInBackground(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onComplete: OnCompleteCallback? = {},
        onDispose: Action = Action { }
    ) {
        buildUseCase(params)
            .subscribeOn(UseCaseSchedulers.jobScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
            }, {
                Timber.e(it, getSubclassPath())
                onError(it)
                dispose()
            }, {
                onComplete?.invoke()
                dispose()
            })
            .let { disposable.add(it) }
    }

    fun dispose() {
        disposable.clear()
    }

}