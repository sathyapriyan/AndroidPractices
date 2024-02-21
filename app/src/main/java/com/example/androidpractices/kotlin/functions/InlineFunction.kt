package com.example.androidpractices.kotlin.functions

// Declaration of an inline function
/*
* Inline function instruct compiler to insert the complete body of the function wherever that function gets used in the code.
* Advantage of inline function: Function call overhead doesn't occur. Less overhead and faster program execution.
* hen the function code is very small, it's a good idea to make the function inline.
* When the function code is large and called from so many places,
  it's a bad idea to make the function inline, as the large code will be repeated again and again.
* This is how inline can help us to make the execution fast by avoiding the function calls.
*/
inline fun calculateSum(a: Int, b: Int): Int {
    return a + b
}
inline fun executeAction(action: () -> Unit) {
    println("Executing action")
    action()
}

inline fun higherFunction(x: Int,myCall:(Int)->Int):Int {
    return myCall(x)
}
inline fun <T> myInlineFunction(action: () -> T): T {
    println("Executing inline function")
    return action()
}
fun main() {

    val result = calculateSum(3, 4) // Call to the inline function
    println("Sum: $result") // Output: Sum: 7

    println(higherFunction(6) { a -> a * a })

    executeAction { println("Action executed") }

    val result2 = myInlineFunction {
        println("Executing lambda")
        42
    }
    println("Result: $result2")
}