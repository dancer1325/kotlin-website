import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString

@Serializable
data class Data(val a: Int, val b: String)

fun main() {
    // 1. serialize
    val classInstance = Json.encodeToString(Data(42, "str"))
    println("1. serialize - classInstance " + classInstance)

    val dataList = listOf(Data(42, "str"), Data(12, "test"))
    val jsonList = Json.encodeToString(dataList)
    println("1. serialize - jsonList " + jsonList)

    // 2. deserialize
    val deserialize = Json.decodeFromString<Data>("""{"a":42, "b": "str"}""")
    println("2. deserialize - deserialize " + deserialize)
}