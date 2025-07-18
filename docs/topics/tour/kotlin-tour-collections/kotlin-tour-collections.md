[//]: # (title: Collections)

* allows
  * data -- is grouped into -- structures
* types
  * 👁️mutable & read-only / collection type 👁️

| **Collection type** | **Description**                                                         |
|---------------------|-------------------------------------------------------------------------|
| Lists               | Ordered collections of items                                            |
| Sets                | Unique unordered collections of items                                   |
| Maps                | Sets of key-value pairs where keys are unique and map to only one value |


## List

* := ordered collection of items
  * allowed
    * duplicated items
* [`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/)
  * 👁️ read only 👁️
    * ⚠️-> writing operations NOT allowed ⚠️ -- _Example:_ `.remove()` --
  * [`listOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/list-of.html)
    * function / create it
  * [allowed functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/#functions)
    * `.first()`, `.last()` & `count()`
      * extension functions
* [`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list.html)
  * 👁️mutable 👁️
    *  ⚠️ Although you declare a variable as `val` -> you can add (`.add()`) or remove (`.remove()`) entries ⚠️
  * [`mutableListOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of.html) 
    * function / create it
  * ⚠️— can be cast to a → `List` ⚠️
  * [allowed functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/#functions)
* type inference
  * == infer the type of the items stored
  * if you want to specify -> `List<TypeOfList>` 
* operators can be applied | them
  * `in`
  * `[]`
    * access to an item
      * Reason: 🧠 it's possible because items are ordered 🧠

## Set

* := 👁️ unique unordered 👁️ collection of items
  * if you try to pass several times the same argument → it’s dropped
* [`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/)
  * read-only
    *  ⚠️-> writing operations NOT allowed ⚠️ -- _Example:_ `.remove()` --
  * [`setOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/set-of.html)
    * function / create it
  * [allowed functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/#functions)
    * `.count()`
* [`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/)
  * mutable
    * ⚠️ Although you declare a variable as `val` -> you can add (`.add()`) or remove (`.remove()`) entries ⚠️
  * [`mutableSetOf()`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-set-of.html) 
  * ⚠️— can be cast to a → `Set` ⚠️
  * [allowed functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/#functions)
* type inference
  * == infer the type of the items stored
  * if you want to specify -> `Set<TypeOfSet>` 
* operators can be applied | them
  * `in`
  * `[]`
    * ❌NOT allowed ❌
      * Reason: 🧠 it's unordered 🧠

## Map

* := collection of key-value pairs /
  * key
    * must be unique
  * value
    * can be duplicated
  * [allowed properties](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/#properties)
    * [`keys`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/keys.html)
    * [`values`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/values.html)
* uses
  * look up a value / WITHOUT using a numbered index
* [`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/)
  * read-only
  * [`mapOf(key1 to value1, ...)`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map-of.html)
    * function / create it
* [`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/)
  * mutable
    * ⚠️ Although you declare a variable as `val` -> you can add (`.add()`) or remove (`.remove()`) entries ⚠️
  * [`mutableMapOf(key1 to value1, ...)`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-map-of.html)
  * ⚠️— can be cast to a → `Map` ⚠️
* type inference
  * == infer the type of the items stored
  * if you want to specify -> `Map<TypeOfKeys, TypeOfValues>` 
* operators can be applied | them
  * `[key]`
    * allows
      * accessing it's value
      * adding items
    * if key does NOT exist -> return `null`
  * `in`
