package com.example.androidpractices.kotlin.functions


/* combine multiple functions to create a new function that is called function Composition */
fun square(x:Int):Int = x*x
fun double(x:Int):Int = x*2
fun squareAndDouble(x: Int,square:(Int)->Int,double:(Int)->Int):Int {return double(square(x))}

infix fun <A, B, C> ((A) -> B).then(other: (B) -> C): (A) -> C {
    return { other(this(it)) }
}
    /*
    Let’s break down what this function has to do.
    We define a function then with three generic types: A, B and C.
    It is an extension of the lambda function: (A) -> B.
    It accepts one parameter of type (B) -> C.
    It returns a lambda function of type (A) -> C.
    Prefix the function with infix.*/

fun main() {

    val squareAndDouble:(Int)->Int={x-> double(square(x)) }

    println("squareAndDouble ${squareAndDouble(2)}")

    println("squareAndDouble ${squareAndDouble(2, { it * it }, { it * 2 })}")

    val f1: (Int) -> Double = { it * 100.0 }
    val f2: (Double) -> Double = { 10.5 - it }

    val range = 1..10
    println(range.map(f1 then f2))
}