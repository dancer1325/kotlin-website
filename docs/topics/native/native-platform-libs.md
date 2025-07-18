[//]: # (title: Platform libraries)

* Kotlin/Native 
  * **Platform Libraries**
    * == prebuilt libraries 
      * specific / EACH target
      * -- provide access to -- user's native OS services

### POSIX bindings

* POSIX platform lib
  * uses
    * 👀| ALL Unix- or Windows-based targets (ALSO included Android & iOS)👀
      * ❌NOT available | [WebAssembly](https://en.wikipedia.org/wiki/WebAssembly)❌ 
  * == bindings -- to -- platform's implementation of the [POSIX standard](https://en.wikipedia.org/wiki/POSIX)
  * how to use it?

    ```kotlin
    import platform.posix.*
    ```

    * `platform.posix`'s content != / platforms
      * Reason: 🧠== differences / POSIX implementations 🧠

### Popular native libraries

* Kotlin/Native 
  * provides access to
    * OpenGL,
    * zlib 
    * others
      * _Example:_ | Apple platforms, `objc` library -- is provided for -- interoperability with [Objective-C](https://en.wikipedia.org/wiki/Objective-C)
    *  see the contents of `dist/klib/platform/$target`

## Availability by default

* platform libraries' packages are available by default
  * == NO need special link flags to use them
    * Reason: 🧠 Kotlin/Native compiler -- automatically detects the -- platform libraries / have been accessed -> links the libraries

* platform libs | distribution == wrappers & bindings to the native libraries
  * == native libraries themselves (`.so`, `.a`, `.dylib`, `.dll` etc) -- should be -- installed | machine
