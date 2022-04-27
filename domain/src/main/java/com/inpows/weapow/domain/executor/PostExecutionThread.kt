package com.inpows.weapow.domain.executor

import io.reactivex.Scheduler




/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version PostExecutionThread, v 0.1 20/04/22 11.46 by Fauhan Handay Pugar
 */

interface PostExecutionThread {
    fun getScheduler(): Scheduler?
}