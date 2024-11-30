[//]: # (title: Kotlin/Native memory management)


* Kotlin/Native's memory manager
  * == Java, Go or Swift's memory manager
  * 👀features👀
    * Objects
      * are stored | shared heap
      * -- can be accessed from -- ANY thread
    * Tracing garbage collection (GC) -- is performed -- periodically collecting objects / NOT reachable from the "roots" (_Example:_
      like local and global variables)

## Garbage collector

* Kotlin/Native's GC algorithm is constantly evolving
  * stop-the-world mark + concurrent sweep collector / heap is NOT separated into generations ❓
    * stop-the-world mark == full parallel mark / combines paused mutators + GC thread + optional marker threads
      * | marking process, by default, paused mutators + >=1 GC thread
      * if you want to disable the full parallel mark -> pass `-Xbinary=gcMarkSingleThreaded=true` compilation option
        * may increase -- the -- pause time of the garbage collector
    * GC thread
      * == GC is 
        * executed | separate thread
        * started -- based on the -- timer & memory pressure heuristics  

* once the marking phase is completed -> 
  * GC processes weak references &
  * nullifies reference -- points to an -- unmarked object
* if you want to decrease the GC pause time -> enable the concurrent processing of weak references -- via -- `-Xbinary=concurrentWeakSweep=true` compilation option

* GC can be [called manually](#enable-garbage-collection-manually)

### Enable garbage collection manually

* call `kotlin.native.internal.GC.collect()`
  * -> triggers a new collection & waits for its completion

### Monitor GC performance

* if you want to enable logging -> set the following compiler option | Gradle build script

    ```none
    -Xruntime-logs=gc=info
  
    // default
    //-Xruntime-logs=gc=error
    ```

* | Apple platforms, use Xcode Instruments toolkit
  * way to track GC-related pauses
    1. Open Xcode, go to **Product** | **Profile** or press <shortcut>Cmd + I</shortcut>
       1. -> compiles your app & launches Instruments
    2. | template selection, select **os_signpost**
    3. specify `org.kotlinlang.native.runtime` as **subsystem** & `safepoint` as **category**
    4. Click the red record button to run your app and start recording signpost events

       ![Tracking GC pauses as signposts](/docs/images/multiplatform/native-gc-signposts.png)
  * previous feature
    * enabled, by default
    * if you want to disable -> specify `-Xbinary=enableSafepointSignposts=false` compiler option

### Disable garbage collection

* use cases to disable garbage collection
  * testing purposes
  * if you encounter issues & have a short-lived program
* | Gradle build script 

    ```none
    -Xgc=noop
    ```

* if it's disabled -> memory consumption will keep rising -> 👀careful NOT exhaust the system memory 👀

## Memory consumption

* 💡Kotlin/Native uses its OWN [memory allocator](https://github.com/JetBrains/kotlin/blob/master/kotlin-native/runtime/src/alloc/custom/README.md) 💡/
  * 👀system memory -- is divided into -- pages 👀
    * -> sweeping
      * independent 
      * in consecutive order
    * EACH allocation == memory block | page
      * the page -- keeps track of -- block sizes 
      * DIFFERENT page types -- are optimized for -- various allocation sizes
      * consecutive arrangement of memory blocks -> efficient iteration | ALL allocated blocks
  * includes protection -- against -- sudden spikes | memory allocations
    * -> prevents certain situations 
      * _Example:_ mutator starts to allocate a lot of garbage quickly & the GC thread can NOT keep up with it == memory usage grow endlessly
        * -> GC forces a stop-the-world phase | UNTIL the iteration is completed

* if a thread allocates memory -> the thread -- searches for a -- suitable page / -- based on the -- allocation size
  * threads maintain a set of pages / DIFFERENT size categories
  * current page / given size -- can accommodate the -- allocation
    * if not -> the thread -- from the shared allocation space, requests a -- different page /
      * this page MAY
        * already be available,
        * require sweeping, or
        * have to be created first

### Check for memory leaks

* TODO:
To access the memory manager metrics, call `kotlin.native.internal.GC.lastGCInfo()`. This method returns statistics for the last
run of the garbage collector. The statistics can be useful for:

* Debugging memory leaks when using global variables
* Checking for leaks when running tests

```kotlin
import kotlin.native.internal.*
import kotlin.test.*

class Resource

val global = mutableListOf<Resource>()

@OptIn(ExperimentalStdlibApi::class)
fun getUsage(): Long {
    GC.collect()
    return GC.lastGCInfo!!.memoryUsageAfter["heap"]!!.totalObjectsSizeBytes
}

fun run() {
    global.add(Resource())
    // The test will fail if you remove the next line
    global.clear()
}

@Test
fun test() {
    val before = getUsage()
    // A separate function is used to ensure that all temporary objects are cleared
    run()
    val after = getUsage()
    assertEquals(before, after)
}
```

### Adjust memory consumption

If there are no memory leaks in the program, but you still see unexpectedly high memory consumption,
try updating Kotlin to the latest version. We're constantly improving the memory manager, so even a simple compiler
update might improve memory consumption.

If you continue to experience high memory consumption after updating, several options are available:

* Switch to a different memory allocator by using one of the following compilation options in your Gradle build script:

  * `-Xallocator=mimalloc` for the [mimalloc](https://github.com/microsoft/mimalloc) allocator.
  * `-Xallocator=std` for the system allocator.

* If you use the mimalloc allocator, you can instruct it to promptly release memory back to the system.
  To do so, enable the following binary option in your `gradle.properties` file:

  ```none
  kotlin.native.binary.mimallocUseCompaction=true
  ```

  It's a smaller performance cost, but it yields less certain results than the standard system allocator does.

If none of these options improves your memory consumption, report an issue in [YouTrack](https://youtrack.jetbrains.com/newissue?project=kt).

## Unit tests in the background

In unit tests, nothing processes the main thread queue, so don't use `Dispatchers.Main` unless it was mocked. Mocking it can
be done by calling `Dispatchers.setMain` from `kotlinx-coroutines-test`.

If you don't rely on `kotlinx.coroutines` or if `Dispatchers.setMain` doesn't work for you for some reason, try the
following workaround for implementing the test launcher:

```kotlin
package testlauncher

import platform.CoreFoundation.*
import kotlin.native.concurrent.*
import kotlin.native.internal.test.*
import kotlin.system.*

fun mainBackground(args: Array<String>) {
    val worker = Worker.start(name = "main-background")
    worker.execute(TransferMode.SAFE, { args.freeze() }) {
        val result = testLauncherEntryPoint(it)
        exitProcess(result)
    }
    CFRunLoopRun()
    error("CFRunLoopRun should never return")
}
```
{initial-collapse-state="collapsed"}

Then, compile the test binary with the `-e testlauncher.mainBackground` compiler flag.

## What's next

* [Migrate from the legacy memory manager](native-migration-guide.md)
* [Configure integration with iOS](native-ios-integration.md)
