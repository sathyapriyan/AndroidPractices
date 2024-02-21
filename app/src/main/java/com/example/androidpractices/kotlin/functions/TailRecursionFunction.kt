package com.example.androidpractices.kotlin.functions

import java.math.BigInteger

    /*In normal recursion, you perform all recursive calls first,
    and calculate the result from return values at last (as show in the above example).
    Hence, you don't get result until all recursive calls are made.

    In tail recursion, calculations are performed first,
    then recursive calls are executed (the recursive call passes
    the result of your current step to the next recursive call).
    This makes the recursive call equivalent to looping, and avoids the risk of stack overflow.*/

/*
* Not eligible for tail recursion because
  the function call to itself n*factorial(n-1) is not the last operation.

    fun factorial(n: Int): Long {

    if (n == 1) {
        return n.toLong()
    } else {
        return n*factorial(n - 1)
    }
    }

* Eligible for tail recursion because function call to itself fibonacci(n-1, a+b, a) is the last operation.

    fun fibonacci(n: Int, a: Long, b: Long): Long {
    return if (n == 0) b else fibonacci(n-1, a+b, a)
    }

* */



tailrec fun fibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    println("n $n | a $a | b $b")

    return if (n == 0) a else fibonacci(n = n-1, a = b, b =a+b)
}

//Factorial Using Tail Recursion
tailrec fun factorial(n: Int, run: Int = 1): Long {
    return if (n == 1) run.toLong() else factorial(n-1, run*n)
}

fun main() {
    val n = 5
    val first = BigInteger("0")
    val second = BigInteger("1")

    println(fibonacci(n, first, second))

    val number = 5
    println("Factorial of $number = ${factorial(number)}")
}