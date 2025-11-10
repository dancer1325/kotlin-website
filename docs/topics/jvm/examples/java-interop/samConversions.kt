val runnable = Runnable { println("This runs in a runnable") }

// SAM conversion
val executor = ThreadPoolExecutor()
// Java signature: void execute(Runnable command)
executor.execute { println("This runs in a thread pool") }      // Lambda converted -- into -- Java interface


// MULTIPLE methods
executor.execute(Runnable { println("This runs in a thread pool") })
