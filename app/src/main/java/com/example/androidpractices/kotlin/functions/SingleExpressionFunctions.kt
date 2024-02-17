package com.example.androidpractices.kotlin.functions


        /*
        Single-Expression Functions:

        Shorter Syntax:
            Single-expression functions can be defined more concisely using the = operator.*/

fun isPositive(number: Int) = number > 0 // Single-expression function

fun max(a: Int, b: Int) = if (a > b) a else b // Using conditional expression

fun main(){
    val result1= isPositive(3)
    val result2= max(a = 5, b = 2)

    println("isPositive 3 ---> $result1")
    println("max 5 or 2 ---> $result2")

}