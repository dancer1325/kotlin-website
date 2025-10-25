import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

//sampleStart
// More than 50% of professional developers who use coroutines
// report increased productivity
// (based on Google's internal data)

fun main() = runBlocking {
    val start = System.currentTimeMillis()
    coroutineScope {                                 // Create a scope for coroutines
        val waitingJob = launch {                    // Launching a coroutine
            waiting(start, 150)
        }
        countdownSignals(10, 300).collect { value -> // Collecting flow elements
            log(start, "Countdown: $value")
        }
        waitingJob.cancel()                          // Cancelling a coroutine
    }
    log(start, "Liftoff!")                           // Execution continues when all
}                                                    // coroutines have finished
//sampleEnd
fun countdownSignals(n: Int, delayMillis: Long): Flow&lt;Int> = flow { // Flow builder
    for (i in (1..n).reversed()) {
        delay(delayMillis)                           // Delay in emitting signals
        emit(i)                                      // Emit the flow element
    }
}

// A function that can be suspended and resumed later
suspend fun waiting(start: Long, delayMillis: Long) {
    while (currentCoroutineContext().isActive) {     // Check coroutine's context
        log(start, "Waiting...")
        delay(delayMillis)                           // Waiting concurrently
    }
}

fun log(start: Long, msg: String) {
    println("$msg after ${(System.currentTimeMillis() - start)/1000F}s")
}
