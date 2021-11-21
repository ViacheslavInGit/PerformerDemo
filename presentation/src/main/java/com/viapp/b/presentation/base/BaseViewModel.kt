package com.viapp.b.presentation.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

abstract class BaseViewModel(
) {

    private var _scope: CoroutineScope? = null
    protected val scope: CoroutineScope get() = requireNotNull(_scope)

    open fun init(
        scope: CoroutineScope,
    ) {
        this._scope = scope
    }


    private val jobMap = mutableMapOf<String, Job>()
    protected fun Job.executeUnique(
        jobName: String,
    ) {
        jobMap[jobName]?.cancel()
        jobMap[jobName] = this
    }
}