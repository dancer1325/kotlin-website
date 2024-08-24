[//]: # (title: Null safety)

* `null`
  * 👁️possible to get | Kotlin 👁️
  * uses
    * something is missing
    * something is NOT yet set
* null safety | Kotlin
  * 👁️== detects potential problems with `null` values | compile-time 👁️
    * != | run-time (as MOST of the program languages)
  * allows
    * declaring explicitly when `null` values are allowed == nullable types
    * checking for `null` values
    * using safe calls to properties or extension or member functions / -- may contain -- `null` values
    * declaring actions to take if `null` values are detected.

## Nullable types

* == types / admit to have `null` values
* ⚠️by default, a type does **NOT** accept `null` values ⚠️
* `... Type? ..`

## Check for null values

* uses
  * | conditional expressions

## Use safe calls

* | properties -- `instance?.propertyName` --
  * if the instance is `null` → returns `null`
  * can be chained --  `instance?.propertyName1?.propertyName2` --
  * uses
    * avoid throwing errors
* | extension or member function
  * if the instance is `null` → returns `null` 
    * null check is performed | before invoking the function


## Use Elvis operator `?:`

* `SomethingWhichCanBeNull ?: ValueToReturnIfItsNull`
* allows
  * declaring a default value
* alternative to Java's ternary operator | Kotlin
