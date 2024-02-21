package com.example.androidpractices.kotlin.functions

    /*Infix Functions:
    Definition:
        Infix functions are functions marked with the infix keyword.
        They allow for more readable function calls when used with infix notation.*/

    /*
    *       1. All INFIX Functions are Extension functions
    *            But all Extension functions are not INFIX
    *       2. INFIX Functions just have ONE PARAMETER
    * */

infix fun Int.addSuffix(suffix: String): String {
    return "$this$suffix"
}
infix fun Int.findGreaterValue(other: Int): Int {       // INFIX and Extension Func

    return if (this > other)
        this
    else
        other
}
class Person(val name: String) {
    infix fun sayHelloTo(other: Person) {
        println("$name says hello to ${other.name}")
    }
}
class MathOperation(private val value: Double,private val key: Double) {
    infix fun plus(other: Double): Double {
        return this.value + other
    }

    infix fun minus(other: Double): Double {
        return this.value - other
    }

    infix fun times(other: Double): Double {
        return this.value * other
    }

    infix fun dividedBy(other: Double): Double {
        require(other != 0.0) { "Division by zero is not allowed" }
        return this.value / other
    }


}
class Structure() {
    infix fun  createPyramid(rows: Int) {
        var k = 0
        for (i in 1..rows) {
            k = 0
            for (space in 1..rows-i) {
                print("  ")
            }
            while (k != 2*i-1) {
                print("* ")
                ++k
            }
            println()
        }
    }
}

// DSL for defining user profiles
class UserProfileDSL {
    data class UserProfile(var name: String = "", var age: Int = 0, var city: String = "")

    // Infix function for setting the user's name
    infix fun UserProfile.name(name: String) {
        this.name = name
    }

    // Infix function for setting the user's age
    infix fun UserProfile.age(age: Int) {
        this.age = age
    }

    // Infix function for setting the user's city
    infix fun UserProfile.city(city: String) {
        this.city = city
    }
}

fun main(){

    val result = 10 addSuffix "th" // Using infix notation
    println(result)

    val x: Int = 6
    val y: Int = 10

    val greaterVal = x findGreaterValue y   // x.findGreaterValue(y)

    println(greaterVal)

    val person1 = Person("Alice")
    val person2 = Person("Bob")

    person1 sayHelloTo person2 // Using infix notation
    // Output: Alice says hello to Bob

    val result2 = MathOperation(10.0,20.0) // Starting value

    // Performing mathematical operations using infix notation
    val finalResult = result2.plus( 5.0)

    println("Final Result: $finalResult") // Output: Final Result: 12.0

    val a = 5 shl 2
    println(a)

    val p = Structure()
    p createPyramid 5       // p.createPyramid(4)

    // Using the DSL to define a user profile
/*
    val userProfile = UserProfileDSL().apply {

        name "John Doe"
        age 25
        city "Example City"
    }
*/

    // Printing the user profile
  //  println("User Profile: $userProfile")
}