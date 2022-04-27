package com.inpows.weapow.domain.core.usecase

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import com.inpows.weapow.domain.dashboard.model.Result

abstract class FlowUseCase<in P, R : Any>(
    private val coroutineDispatcher: CoroutineDispatcher
) : CoroutineScope by CoroutineScope(coroutineDispatcher) {

    protected open var supervisorJob = SupervisorJob()

    abstract fun execute(params: P): Flow<Result<R>>

    @JvmOverloads
    operator fun invoke(
        params: P,
        onSuccess: (result: R) -> Unit = {},
        onError: (e: Exception) -> Unit = {}
    ) {
        val handler = CoroutineExceptionHandler { _, throwable ->
            launch(coroutineDispatcher) {
                onError(Exception(throwable))
            }
        }
        launch(handler + supervisorJob) {
            execute(params)
                .catch { e -> emit(Result.Error(Exception(e))) }
                .flowOn(coroutineDispatcher)
                .collect { result ->
                    when(result) {
                        is Result.Success -> withContext(Dispatchers.Main) {
                            onSuccess(result.data)
                        }
                        is Result.Error -> withContext(Dispatchers.Main) {
                            onError(result.exception)
                        }
                    }
                }
        }
    }

    fun dispose() = supervisorJob.cancel()

    fun cancelChildren() = supervisorJob.cancelChildren()
}