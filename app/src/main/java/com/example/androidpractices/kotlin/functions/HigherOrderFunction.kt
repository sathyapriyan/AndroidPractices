package com.example.androidpractices.kotlin.functions

import java.util.concurrent.locks.Condition


//higherOrder Function that returns a function
fun multipleBy(factor:Int):(Int)-> Int{ return { number -> number*factor} }
    /*multipleBy - higherOrder Function
    * That Take an Integer (factor) // (factor:Int) - constructor
    * return a function (Int)->Int */

data class Person2(val name:String,val age:Int)

//higherOrder Function use Extension Function
fun List<Person2>.filterByCondition(condition: (Person2)->Boolean):List<Person2>{
    return this.filter {person -> condition(person) }
}
/* List<Person2> - Extension
* filterByCondition - HigherOrder Function
* Person2 - Data Class
*  */

fun <T> List<T>.filterByCondition2(condition: (T)->Boolean):List<T>{
    return this.filter {dataClass -> condition(dataClass) }
}

fun operationSelector(operationType:String):(Int,Int)->Int{
    return when(operationType){
        "add" -> {a,b->a+b}
        "subtract" -> {a,b->a-b}
        else -> throw IllegalArgumentException("Unknown Operation Type")
    }
}

fun main(){
    val multipleByTwo = multipleBy(2)
    val multipleByThree = multipleBy(3)

    val result1 = multipleByTwo(2)
    val result2 = multipleByThree(2)

    println("result1 $result1")
    println("result2 $result2")

    val people = listOf(
        Person2(name = "Test1",age =10),
        Person2(name = "Test4",age =15),
        Person2(name = "Test2",age =20),
        Person2(name = "Test3",age =30),
        Person2(name = "Test4",age =40))

    val adults = people.filterByCondition { it.age>=18 }
    val minors = people.filterByCondition { it.age<18 }

    println("adults $adults")
    println("minors $minors")


    val operationSelector = operationSelector(operationType="add")
    val result3=operationSelector(2,5)
    val result4=operationSelector(operationType="subtract")(8,5)
    println("result3 $result3")
    println("result4 $result4")
}