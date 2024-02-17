package com.example.androidpractices.kotlin.functions


        /*Parameters:
        Positional Parameters:
            Parameters are specified within parentheses following the function name.
            They can have default values.
        Named Parameters:
            Arguments can be passed to parameters by name, allowing for more readable function calls.
            Useful when calling functions with many parameters or when passing parameters in a different order.

        Default Arguments:
            Function parameters can have default values, allowing for optional parameters when calling the function.
            Parameters with default values must be specified after parameters without default values.

        Return Types:
        Explicit Return Types:
            Functions specify their return type after a colon (:) following the parameter list.
            Use Unit if a function doesn't return any meaningful value (similar to void in Java/C++).
        Inferred Return Types:
            For simple functions, Kotlin can infer the return type based on the implementation.
            If the function body consists of a single expression, the return type can be omitted, and the return type will be inferred from the expression.*/


fun add(a:Int=0,b:Int=0):Int { // a is a parameter, :Int is a parameter type, a:Int=0 default variable
    return a+b                 // Explicit Return Types:
}
fun sub(a:Int=0,b:Int=0):Unit { //Use Unit if a function doesn't return any meaningful value
}
fun multiply(a: Int, b: Int) = a * b // Inferred return type: Int

fun main(){

    val result1 = add(a = 2, b = 3) // a  = and b = is the named parameter
    val result2 = add(2,3)
    val result3 = add(a = 2,3)
    val result4 = add(2, b = 3)
    val result5 = add(2)
    val result6 = add(a = 2)
    val result7 = add(b = 2)

    println(result1)
    println(result2)
    println(result3)
    println(result4)
    println(result5)
    println(result6)
    println(result7)
}