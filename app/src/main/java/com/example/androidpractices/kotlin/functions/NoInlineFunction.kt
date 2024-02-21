package com.example.androidpractices.kotlin.functions

/*
* Assume that we do not want all of the lambdas passed to an inline function to be inlined,
  in that case, we can mark those function parameters with the noinline modifier.
* Here, we can see that the lambda(xyz) has not got inlined as expected. Only the lambda(abc) got inlined.
  This is how noinline in Kotlin helped us in achieving what we wanted.
* This way, we used the noinline to avoid the inlining.
* */
inline fun teach(abc: () -> Unit, noinline xyz: () -> Unit) {
    abc()
    xyz()
}
fun main() {
    print("guide start")
    teach({
        print("teach abc")
    }, {
        print("teach xyz")
    })
    print("guide end")
}

