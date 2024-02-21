package com.example.androidpractices.kotlin.functions

        /*An anonymous function is very similar to regular function
         except for the name of the function
         which is omitted from the declaration.
         The body of the anonymous function can be either an expression or block.*/


// anonymous function with body as an expression
        val anonymous1 = fun(x: Int, y: Int): Int = x + y

// anonymous function with body as a block
val anonymous2 = fun(a: Int, b: Int): Int {
    val mul = a * b
    return mul
}
fun main(args: Array<String>) {
    //invoking functions
    val sum = anonymous1(3,5)
    val mul = anonymous2(3,5)
    println("The sum of two numbers is: $sum")
    println("The multiply of two numbers is: $mul")
}