package com.example.androidpractices.kotlin.interoperability

fun main() {

    val area = MyJavaFile.getArea(10, 5)
    println("Printing area from Kotlin file: $area")

    val result1 = Test1(color = 1)
    val result2 = Test1(color = 2)
   println(result1 == result2)
}
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

data class Test1(
    val color:Int?
)
class Test2(){
    val color:Int=0
}