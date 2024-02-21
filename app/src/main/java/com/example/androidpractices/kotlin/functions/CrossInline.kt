package com.example.androidpractices.kotlin.functions

/*
* crossinline in Kotlin is used to avoid non-local returns.
* Now, we can see that everything is as expected. We also have the System.out.print("guide end").
* This is how the crossinline can help us to avoid the "non-local returns".
*/

inline fun teach(crossinline abc: () -> Unit) {
    abc()
}
fun main() {
    print("guide start")
    teach {
        print("teach")
        // return is not allowed here
    }
    print("guide end")
}
