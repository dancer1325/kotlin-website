import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val start = System.currentTimeMillis()
    // 3. structure concurrency -- via -- scopes
    coroutineScope {
        // 1. launch        launch a coroutine
        val waitingJob = launch {
            waiting(start, 150)
        }
        // 4. flow of data stream
        countdownSignals(10, 300).collect { value ->    // collect flow elements
            log(start, "Countdown: $value")
        }
        // 5. cancel a coroutine
        waitingJob.cancel()
    }
    log(start, "Liftoff!")                           // Execution continues when all
}                                                    // coroutines have finished

fun countdownSignals(n: Int, delayMillis: Long): Flow&lt;Int> = flow { // Flow builder
    for (i in (1..n).reversed()) {
        delay(delayMillis)                           // Delay in emitting signals
        emit(i)                                      // Emit the flow element
    }
}

// 2. suspend & resumed later functions
suspend fun waiting(start: Long, delayMillis: Long) {
    while (currentCoroutineContext().isActive) {     // Check coroutine's context
        log(start, "Waiting...")
        delay(delayMillis)                           // Waiting concurrently
    }
}

fun log(start: Long, msg: String) {
    println("$msg after ${(System.currentTimeMillis() - start)/1000F}s")
}
