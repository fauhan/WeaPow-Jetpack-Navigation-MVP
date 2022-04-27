package com.inpows.weapow.data

import com.inpows.weapow.domain.executor.ThreadExecutor
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version JobExecutor, v 0.1 22/04/22 02.28 by Fauhan Handay Pugar
 */
@Singleton
class JobExecutor @Inject constructor() : ThreadExecutor {
    private val threadPoolExecutor: ThreadPoolExecutor

    override fun execute(runnable: Runnable) {
        threadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0
        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "android_" + counter++)
        }
    }

    init {
        threadPoolExecutor = ThreadPoolExecutor(
            3, Int.MAX_VALUE, 10, TimeUnit.SECONDS,
            SynchronousQueue(), JobThreadFactory()
        )
    }
}