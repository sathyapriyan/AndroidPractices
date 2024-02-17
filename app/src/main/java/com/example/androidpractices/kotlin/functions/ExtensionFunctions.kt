package com.example.androidpractices.kotlin.functions

        /* Extension Functions:

        Definition:
            1.Extension functions allow you to add new functions to existing classes without modifying their source code.
            2.They enhance the functionality of classes without inheritance.
        */

fun String.isEmail(): Boolean {
        return this.contains("@") && this.contains(".")
}
fun String.capitalizeFirstLetter():String {
        return this.substring(0,1).uppercase()+this.substring(1)
}
fun List<Int>.sum():Int{
        var total=0
        for (i in this){
                total +=i
        }
        return total
}
fun String.isPalindrome(): Boolean {
        return this == this.reversed()
}
// Extension function to find the median value of a list of numbers
fun List<Int>.median(): Double {
        val sortedList = this.sorted()
        val size = sortedList.size

        return if (size % 2 == 0) {
                val middleIndex = size / 2
                (sortedList[middleIndex - 1] + sortedList[middleIndex]) / 2.0
        } else {
                sortedList[size / 2].toDouble()
        }
}


fun Student.isScholar(marks: Int): Boolean {
        return marks > 95
}

class Student {         // OUR OWN CLASS

        fun hasPassed(marks: Int): Boolean {
                return marks > 40
        }
}

fun main(){
        val email = "user@example.com"
        val isEmail = email.isEmail() // true
        println(isEmail)

        val name = "testName" // true
        val uppercaseName = name.capitalizeFirstLetter() // TestName
        println(uppercaseName)

        val list = listOf(1,2,3,4,5,6,7,8,9,10)
        println(list.sum()) // out put is 55

        val value = "madam"
        if(value.isPalindrome()){
         println("$value is Palindrome")
        }else{
         println("$value is Not Palindrome") // madam is Palindrome
        }

        val numbers = listOf(1, 2, 5, 6, 10, 13, 14)
        val median = numbers.median()
        println("Median value: $median") // Output: Median value: 6.0

        val student = Student()
        println("Pass status: " + student.hasPassed(57))

        println("Scholarship Status: " + student.isScholar(57))
}