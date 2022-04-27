package com.inpows.weapow.domain.core.usecase

import com.inpows.weapow.domain.dashboard.model.Result

abstract class CoroutineWorkerUseCase<in P, R : Any> {

    abstract suspend fun execute(param: P): R

    suspend operator fun invoke(param: P): Result<R> = try {
        Result.Success(execute(param))
    } catch (e: Exception) {
        Result.Error(e)
    }
}