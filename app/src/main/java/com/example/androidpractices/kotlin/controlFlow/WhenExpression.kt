package com.example.androidpractices.kotlin.controlFlow

fun main(){
    val a =10

    val result:String = when(a){
        10 -> "A"
        8 -> "B"
        8 -> "C"
        7 -> "D"
        6 -> "E"
        else -> "U"
    }
    println(" result ---> $result")
}