package com.example.androidpractices.kotlin.functions

 //Lambda as a Function Argument:
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    //Lambda with No Parameters
    val company = { println("Lambdas Result 1")}

    // invoking function method1
    company()

    // invoking function method2
    company.invoke()

    //Lambda with Parameters:
    // with type annotation in lambda expression
    val sum = {a: Int , b: Int -> a + b}
    println("Lambdas Result 2 --> ${sum(1, 2)}")

    // without type annotation in lambda expression
    val sum2:(Int,Int)-> Int  = { a , b -> a + b}

    println("Lambdas Result 2 --> ${sum2(1, 2)}")

    val sum3 = { a: Int, b: Int ->
        val num = a + b
        num.toString()     //convert Integer to String
    }
    println("Lambdas Result 3 --> ${sum2(1, 2)}")

    //Lambdas examples with return type:
    val lambda1: (Int) -> Int = { a -> a * a}
    val lambda2: (String,String) -> String = { a , b -> a + b }
    val lambda3: (Int)-> Unit = {print(Int)}

    //Lambdas can be used as class extension:
    val lambda4: String.(Int) -> String = {this + it}
    println("lambda4 --> ${"Test".lambda4(4)}")

    //Lambda in a Higher-Order Function
    val numbers1 = listOf(1, 2, 3, 4, 5)
    val squaredNumbers = numbers1.map { it * it }
    println("Positive squaredNumbers --> $squaredNumbers")

    // squaredNumbers is [1, 4, 9, 16, 25]

    //Lambda with a Predicate:
    //Kotlin program using shorthand form of lambda function
    val numbers = arrayOf(1,-2,3,-4,5)

    val evenNumbers = numbers.filter { it % 2 == 0 }
    // evenNumbers is [2, 4]
    println("Positive evenNumbers --> $evenNumbers")

    println("Positive numbers --> ${numbers.filter {  it > 0 }}")

    //Kotlin program using longhand form of lambda function
    println("Positive numbers --> ${numbers.filter {item -> item > 0 }}")

   //Kotlin program to return String value by lambda function
    val find =fun(num: Int): String{
        return if(num % 2==0 && num < 0) {
            "Number is even and negative"
        } else if (num %2 ==0 && num >0){
            "Number is even and positive"
        } else if(num %2 !=0 && num < 0){
            "Number is odd and negative"
        } else {
            "Number is odd and positive"
        }
    }
    val result = find(112)
    println(result)

    // Lambda as a Function Argument:
    val addition = operateOnNumbers(3, 4) { x, y -> x + y }
    val multiplication = operateOnNumbers(3, 4) { x, y -> x * y }
    // addition is 7, multiplication is 12
}