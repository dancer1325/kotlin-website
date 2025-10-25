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
        countdownSignals(10, 300)
            .onEach { value: Int -> log(start, "Countdown: $value") }
            .collect()    // collect without lambda
        // 5. cancel a coroutine
        waitingJob.cancel()
    }
    log(start, "Liftoff!")
}

fun countdownSignals(n: Int, delayMillis: Long): Flow<Int> = flow {
    for (i in (1..n).reversed()) {
        delay(delayMillis)
        emit(i)
    }
}

// 2. suspend & resumed later functions
suspend fun waiting(start: Long, delayMillis: Long) {
    while (currentCoroutineContext().isActive) {
        log(start, "Waiting...")
        delay(delayMillis)
    }
}

fun log(start: Long, msg: String) {
    println("$msg after ${(System.currentTimeMillis() - start)/1000F}s")
}
