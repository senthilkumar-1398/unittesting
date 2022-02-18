package com.example.unittest11_08_2021.datastoretest

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CoroutineTestCase: CoroutineScope {
    val job = Job()
    var value = 1
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Unconfined


    fun testFunction(): Deferred<Unit> {
        return async {
            delay(5000)
            value = 2
        }
    }
}
