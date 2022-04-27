package com.inpows.weapow.domain.core.usecase

import android.util.Log
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

abstract class SingleUseCase<T, Params> @JvmOverloads constructor(
    private val jobScheduler: Scheduler = Schedulers.io(),
    private val postScheduler: Scheduler = AndroidSchedulers.mainThread()
) {

    private val disposable = CompositeDisposable()

    /**
     * Build observable use case.
     *
     * @param params Use [NoParams] if you don't mind to pass any parameter.
     */
    abstract fun buildUseCase(params: Params): Single<T>

    @JvmOverloads
    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {}
    ) {
        execute(params, onSuccess, onError, {})
    }

    fun execute(
        params: Params,
        onSuccess: OnSuccessCallback<T>,
        onError: OnErrorCallback = {},
        onDispose: Action = Action { }
    ) {
        buildUseCase(params)
            .subscribeOn(jobScheduler)
            .observeOn(postScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
                dispose()
            }, {
                Timber.e(it)
                onError(it)
                dispose()
            })
            .let { disposable.add(it) }
    }

    fun dispose() {
        disposable.clear()
    }
}