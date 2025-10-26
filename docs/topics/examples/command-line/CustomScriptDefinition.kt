// Script definition for .custom.kts files
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromCurrentContext
import kotlin.script.experimental.jvm.jvm

@KotlinScript(
    fileExtension = "custom.kts",
    compilationConfiguration = CustomScriptCompilationConfiguration::class
)
abstract class CustomScript

object CustomScriptCompilationConfiguration : ScriptCompilationConfiguration({
    // Auto-import common packages
    defaultImports("java.io.*", "java.util.*")
    
    // Add dependencies
    jvm {
        dependenciesFromCurrentContext(wholeClasspath = true)
    }
    
    // Custom properties available in script
    providedProperties("customProperty" to String::class)
})