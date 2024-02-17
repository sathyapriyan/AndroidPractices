package com.example.androidpractices.kotlin.controlFlow

fun main(){
    for (i in 0..10){
        print(i)
    }
    println()

    for (i in 0 until 10){
        print(i)
    }
    println()

    for (i in 0 .. 10 step 2){
        print(i)
    }
    println()

    for (i in 10 .. 1 ){
        print(i)
    }
    println()

    for (i in 10 downTo  1 ){
        print(i)
    }
    println()

    for (i in 10 downTo  1 step 2 ){
        print(i)
    }
    println()

    var language = arrayOf("Ruby", "Kotlin", "Python", "Java")

    for (item in language)
        print(item)

    println()
    for (i in 0..10){
        print(i)
        if (i==5) break
    }

    println()
    myLoop@ for (i in 1..3) {
        for (j in 1..3) {
            println("$i  $j")
            if (i == 2 && j == 2)
                break@myLoop
        }
    }

    println()
    for (i in 1..3) {
        if (i == 2)
            continue
        print(i)
    }

    println()
    myLoop@ for (i in 1..3) {
        for (j in 1..3) {
            if (i == 2 && j == 2) {
                continue@myLoop
            }
            print("$i  $j")
        }
    }
}