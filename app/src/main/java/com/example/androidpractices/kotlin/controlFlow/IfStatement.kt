package com.example.androidpractices.kotlin.controlFlow


fun main(args: Array<String>){

    val a:Int = 12
    val b = 10
    val c = 12
    val data=true

    if(a==c){
        println("test 1 --> a and c equal")
    }

    if(a!=b){
        println("test 1 --> a and b not equal")
    }

    if(data){
        println("test 1 -->  data is true")
    }else{
        println("test 1 -->  data is false")
    }

    if(a<b){
        println("test 1 --> a less-then b")
    }else if (a>b){
        println("test 1 --> a grater-then b")
    } else{
        println("test 1 --> a equal b")
    }

}