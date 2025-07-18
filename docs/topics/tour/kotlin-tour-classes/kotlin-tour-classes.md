[//]: # (title: Classes)

* object-oriented programming /
  * classes
    * `class ClassName`
    * allows
      * set characteristics | object
      * saving time
        * Reason: 🧠 characteristics are NOT declared every time 🧠	
  * objects
    * allows
      * storing data

## Properties

* == characteristics of a class
  * recommended to declare read-only -- `val` --
  * [trailing comma](coding-conventions.md#trailing-commas) | declaring class properties, can be used
  * default values can be declared
* ways to define them
  * `class ClassName(Properties)`
    * 👁️properties here can be declared without `val` or `var` 👁️
      * ⚠️if an instance is created / NOT specified `val` or `var` -> NOT accessible the property ⚠️  
  * 
    ```
    class ClassName(...){
      properties
      …
    }
    ```

## Create instance

* 👁️way to create an object -- from a -- class 👁️
  * declare a class **instance** -- via a -- **constructor**  
* constructors
  * primary constructor
    * ⚠️ created automatically by Kotlin -- based on the -- classHeader’s parameters ⚠️
  * ALL you want, can be declared constructors
  * check [Constructors](classes.md#constructors)

## Access properties

* `classInstance.propertyName`
  * access a property of an instance
  * allows
    * reading it
    * writing it

## Member functions

* == function / declared | classBody

## Data classes

* `data class className`
* := classes / 👁️ automatically built-in member functions 👁

| **Function**        | **Description**                                                                                                |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| `.toString()`       | * Prints a readable string of the class instance / include its properties.<br/> * Check [Print as string](#print-as-string)                                             |
| `.equals()` or `==` | * Compares instances of a class. <br/> * Check [Compare instances](#compare-instances) |
| `.copy()`           | * Creates a class instance -- via -- copying another / potentially with some different properties. <br/> * Check [Copy instance](#copy-instance) |

### Print as string

* ways to print a readable string of a class instance
  * built-in `.toString()` function
  * print functions / -- internally call -- `.toString()` 
    * `println()`
    * `print()` 
* uses
  * debugging
  * creating logs

### Compare instances

* ways to compare instances
  * built-in `.equals()`
  * `==` / -- internally call -- `.equals()`

### Copy instance

* ways to create an exact copy of an instance
  * `.copy()`
* vs modify the original instance
  * 👁️recommended to create a copy 👁️
