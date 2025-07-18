[//]: # (title: Operator overloading)

* operators | types
  * have
    * predefined symbolic representation (_Example:_ `+` or `*`)
    * precedence
  * 👀built-in 👀
    * [unary operators](#unary-operations)
    * [binary operators](#binary-operations)
  * 👀ALLOWED to customize👀-- via --
    * [member function](functions.md#member-functions) OR
    * [extension function](extensions.md) / specific name -- for the -- corresponding type
  * if 
    * binary operators → type == left hand side
    * unary ones → type == argument type

* `operator fun …`
  * overload an operator

    ```kotlin
    interface IndexedContainer {
        operator fun get(index: Int)
    }
    ```
  * if you [override](inheritance.md#overriding-methods) -> you can omit `operator` overloads

    ```kotlin
    class OrdersList: IndexedContainer {
        override fun get(index: Int) { /*...*/ }   
    }
    ```

## Unary operations

### Unary prefix operators

| Expression | Translated to |
|------------|---------------|
| `+a` | `a.unaryPlus()` |
| `-a` | `a.unaryMinus()` |
| `!a` | `a.not()` |

* expression
  * == | code
* translated to
  * == translated -- by the -- compiler
  * _Example:_ let's have `+a` / type `T`
    * determines the type of `a` 
    * | `T`,
      * looks up a function `unaryPlus()` / has
        * `operator` modifier & NO parameters
          * == member function OR extension function
    * ⚠️if the function is absent or ambiguous -> compilation error⚠️
    * if the function is present & return type `R` -> expression `+a`'s type == `R`

* | [basic types](basic-types.md),
  * 👀these operations are optimized == | call them, NOT overhead👀

### Increments and decrements

| Expression | Translated to |
|------------|---------------|
| `a++` | `a.inc()` + see below |
| `a--` | `a.dec()` + see below |

The `inc()` and `dec()` functions must return a value, which will be assigned to the variable on which the
`++` or `--` operation was used. They shouldn't mutate the object on which the `inc` or `dec` was invoked.

The compiler performs the following steps for resolution of an operator in the *postfix* form, for example `a++`:

* Determines the type of `a`, let it be `T`.
* Looks up a function `inc()` with the `operator` modifier and no parameters, applicable to the receiver of type `T`.
* Checks that the return type of the function is a subtype of `T`.

The effect of computing the expression is:

* Store the initial value of `a` to a temporary storage `a0`.
* Assign the result of `a0.inc()` to `a`.
* Return `a0` as the result of the expression.

For `a--` the steps are completely analogous.

For the *prefix* forms `++a` and `--a` resolution works the same way, and the effect is:

* Assign the result of `a.inc()` to `a`.
* Return the new value of `a` as a result of the expression.

## Binary operations

### Arithmetic operators 

| Expression | Translated to |
| -----------|-------------- |
| `a + b` | `a.plus(b)` |
| `a - b` | `a.minus(b)` |
| `a * b` | `a.times(b)` |
| `a / b` | `a.div(b)` |
| `a % b` | `a.rem(b)` |
| `a..b` | `a.rangeTo(b)` |
| `a..<b` | `a.rangeUntil(b)` |

For the operations in this table, the compiler just resolves the expression in the *Translated to* column.

Below is an example `Counter` class that starts at a given value and can be incremented using the overloaded `+` operator:

```kotlin
data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}
```

### in operator

| Expression | Translated to |
| -----------|-------------- |
| `a in b` | `b.contains(a)` |
| `a !in b` | `!b.contains(a)` |

For `in` and `!in` the procedure is the same, but the order of arguments is reversed.

### Indexed access operator

| Expression | Translated to |
| -------|-------------- |
| `a[i]`  | `a.get(i)` |
| `a[i, j]`  | `a.get(i, j)` |
| `a[i_1, ...,  i_n]`  | `a.get(i_1, ...,  i_n)` |
| `a[i] = b` | `a.set(i, b)` |
| `a[i, j] = b` | `a.set(i, j, b)` |
| `a[i_1, ...,  i_n] = b` | `a.set(i_1, ..., i_n, b)` |

Square brackets are translated to calls to `get` and `set` with appropriate numbers of arguments.

### invoke operator

| Expression | Translated to |
|--------|---------------|
| `a()`  | `a.invoke()` |
| `a(i)`  | `a.invoke(i)` |
| `a(i, j)`  | `a.invoke(i, j)` |
| `a(i_1, ...,  i_n)`  | `a.invoke(i_1, ...,  i_n)` |

* 👀`()` are translated -- to -- calls to `invoke()`👀

### Augmented assignments

| Expression | Translated to |
|------------|---------------|
| `a += b` | `a.plusAssign(b)` |
| `a -= b` | `a.minusAssign(b)` |
| `a *= b` | `a.timesAssign(b)` |
| `a /= b` | `a.divAssign(b)` |
| `a %= b` | `a.remAssign(b)` |

For the assignment operations, for example `a += b`, the compiler performs the following steps:

* If the function from the right column is available:
  * If the corresponding binary function (that means `plus()` for `plusAssign()`) is available too, `a` is a mutable variable, and the return type of `plus` is a subtype of the type of `a`, report an error (ambiguity).
  * Make sure its return type is `Unit`, and report an error otherwise.
  * Generate code for `a.plusAssign(b)`.
* Otherwise, try to generate code for `a = a + b` (this includes a type check: the type of `a + b` must be a subtype of `a`).

> Assignments are *NOT* expressions in Kotlin.
>
{type="note"}

### Equality and inequality operators

| Expression | Translated to |
|------------|---------------|
| `a == b` | `a?.equals(b) ?: (b === null)` |
| `a != b` | `!(a?.equals(b) ?: (b === null))` |

These operators only work with the function [`equals(other: Any?): Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html), 
which can be overridden to provide custom equality check implementation. Any other function with the same name (like `equals(other: Foo)`) will not be called.

> `===` and `!==` (identity checks) are not overloadable, so no conventions exist for them.
>
{type="note"}

The `==` operation is special: it is translated to a complex expression that screens for `null`'s.
`null == null` is always true, and `x == null` for a non-null `x` is always false and won't invoke `x.equals()`.

### Comparison operators

| Expression | Translated to |
|--------|---------------|
| `a > b`  | `a.compareTo(b) > 0` |
| `a < b`  | `a.compareTo(b) < 0` |
| `a >= b` | `a.compareTo(b) >= 0` |
| `a <= b` | `a.compareTo(b) <= 0` |

All comparisons are translated into calls to `compareTo`, that is required to return `Int`.

### Property delegation operators

`provideDelegate`, `getValue` and `setValue` operator functions are described
in [Delegated properties](delegated-properties.md).

## Infix calls for named functions

You can simulate custom infix operations by using [infix function calls](functions.md#infix-notation).
