package com.example.androidpractices.kotlin.classes


data class Student(val name:String?,
                    val id:Int?,
                    val mark1:Int?,
                    val mark2:Int?,
                    val mark3:Int?,
                    var total:Int?) {
    fun getTotal():Int = (mark1?:0)+(mark2?:0)+(mark3?:0)
}
data class User(var name: String, var id: Int)

fun main(){
    val students = listOf(
        Student(name="AAA", id = 1, mark1 = 60, mark2 = 70, mark3 = 80, total = null),
        Student(name="BBB", id = 2, mark1 = 50, mark2 = 60, mark3 = 70, total = null),
        Student(name="CCC", id = 3, mark1 = null, mark2 = 75, mark3 = 85, total = null),
        Student(name="DDDD", id = 4, mark1 = 55, mark2 = 65, mark3 = 75, total = null),
        Student(name="CDDD", id = 4, mark1 = 55, mark2 = 65, mark3 = 75, total = null),
        Student(name="BDDD", id = 4, mark1 = 55, mark2 = 65, mark3 = 75, total = null),
        Student(name="ADDD", id = 4, mark1 = 55, mark2 = 65, mark3 = 75, total = null)
    )
    println("All Students $students")


    students.forEach{
        it.total= (it.mark1 ?: 0) + (it.mark2 ?: 0) + (it.mark3 ?: 0)
    }

    println("All Students with Total $students")

    val selectedStudent = students.filter { it.total!! >= 200 }
    println("more then 200 mark $selectedStudent")

    val selectedStudentName = mutableListOf<String>()
    for(i in selectedStudent.indices){
        selectedStudent[i].name?.let { selectedStudentName.add(it) }
    }
    println(selectedStudentName)

    val selectedStudentStartWithA = students.filter { it.name!!.startsWith("A") }

    println("selected Student Name Start With A $selectedStudentStartWithA")

    val firstMarkStudent = students.maxBy { it.total!! }
    val firstMarkStudent2 = students.maxBy { it.getTotal() }

    println("first mark $firstMarkStudent")
    println("first mark2 $firstMarkStudent2")

    students.forEach{
        println("total ${it.getTotal()}")
    }

    val user1 = User("Sam", 10)

    val user2 = User("Sam", 10)

    println(user1.toString())

    if (user1 == user2)
        println("Equal")
    else
        println("Not equal")

    val newUser = user1.copy(id = 25)
    println(newUser)
}