[//]: # (title: Control flow)

## Conditional expressions

* := boolean piece of code / make decisions

### If

* 

    ```
    if (conditionalExpresion) {
    …
    }
    // OR
    if(conditionalExpression) BodyOf1UniqueLine
    // OR
    if (conditionaExpression) this else that
    ```
    * if body1UniqueLine -> `{}` are optional
    * `condition ? then : else`
      * ❌ternary operator does NOT exist ❌
      * ⭐valid alternative ⭐
        * `if (conditionaExpression) this else that`

### When

* vs `if`
  * 👁️recommended to use `when` 👁️
    * Reasons: 🧠🧠
        * code is easier to read
        * add another branch is easier
        * less prune to errors
* uses
  * conditional expression / multiple branches
  * as
    * statement or  
      * NOTHING is returned 
    * expression
      * _Example:_ assign to a variable
* 

    ```
    when (conditionalExpressionNamedSubject) {
        branch1 -> logic1
        branch2 -> logic2
        ...
        else -> logicEnd
    } 
    // OR
    when {
        conditionalExpression1 -> logic1
        conditionalExpression1 -> logic2
        ...
        else -> logicEnd
    } 
    ```
  * branches are checked sequentially / if once is satisfied -> rest are skipped
  * 👁️recommended to use with `conditionalExpressionNamedSubject` 👁️
    * Reasons: 🧠 🧠
      * code easier to read & maintain
      * helps Kotlin / ALL possible cases are covered 
  * ⚠️if you do NOT use `conditionalExpressionNamedSubject` -> you should provide `else` branch ⚠️

## Ranges

* allowed types
  * `Int`
  * `Char`
* ways to create them
  * `initialValue..finalValue`
    * `initialValue` & `finalValue` are included
    * step = +1
  * `initialValue..<finalValue` & `initialValue until valueWithoutBeingIncluded`
    * `finalValue` is NOT included
  * `initialValue downTo finalValue`
    * range declared in reverse order == `finalValue` -> `initialValue`   
    * step = -1
  * `initialValue..finalValue step StepsToGive`

## Loops

### For

* use
  * iterate over + perform an action
    * you can iterate |
      * `range`
      * collections
* 

    ```
    for (ObjectOverIterate) {
    // perform the action
    }
    ```

### While

* ways to use it
  * `while`
    * check the conditional expression + then perform the action
      * 👁️ -> UNTIL particular condition is satisfied 👁️
    * 

    ```
      while (conditionToBeFulfilled) {
      // perform the action
      }
    ```

  * `do-while`
    * perform the action + then check the conditional expression
      * 👁️ vs `while` is reverse order 👁️
    * 
    
    ```
      do {
      // perform the action
      } while (conditionToBeFulfilled) {
      }
    ```
