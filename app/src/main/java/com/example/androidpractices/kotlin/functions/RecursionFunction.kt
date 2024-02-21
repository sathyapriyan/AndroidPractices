package com.example.androidpractices.kotlin.functions


/*A function that calls itself is known as recursive function. And, this technique is known as recursion.*/
fun factorial(x:Int):Long{
    return if(x==1) x.toLong() else x* factorial(x=x-1)
}

//Sum of Natural Numbers Using Recursion
fun addNumbers(num: Int): Int {
    return if (num != 0)
        num + addNumbers(num - 1)
    else
        num
}
//GCD of Two Numbers using Recursion
fun hcf(n1: Int, n2: Int): Int {
    return if (n2 != 0)
        hcf(n2, n1 % n2)
    else
        n1
}
fun main() {
    val result = factorial(5)
    println("result $result")

    val number = 20
    val sum = addNumbers(number)
    println("Sum = $sum")

    val n1 = 366
    val n2 = 60
    val hcf = hcf(n1, n2)
    println("G.C.D of $n1 and $n2 is $hcf.")
}
