package com.example.androidpractices.kotlin.classes

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

/*Enum classes also known as Enumeration Class in Kotlin
is a feature that allows us to define a class that stores a fixed set of values.*/

    /*Some Important Points About Enum Classes in Kotlin
    Enum Constants, Properties, and Methods:
    Enum class in Kotlin can not only have constants but also have methods and properties.
    Instance-like behavior:
    Each enum constant can act as a separate instance which implies that we can access properties and call methods on individual constants of the enum class.
    Readability Enhancement:
    Enum in Koltin enhances the readability of the code and is self-explanatory.
    No Constructor Instantiation:
    Though we call it Enum classes, we are not allowed to create an instance or object of the Enum class using a constructor. Enum types cannot be instantiated.*/

    /*Syntax
    enum class class_name(val property: type){
        // constants
        // methods
        // properties
    }*/

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
interface ICardCashBack {
    fun getCashbackValue(): Float
}
enum class CreditCardType(val color: String, val maxLimit: Int = 1000000): ICardCashBack {
    SILVER("gray", 50000) {
        override fun getCashbackValue(): Float = 0.02f
    },
    GOLD("gold"){
        override fun getCashbackValue(): Float = 0.04f
    },
    PLATINUM("black"){
        override fun getCashbackValue(): Float = 0.06f
    }
}

enum class TShirtSize(val abbreviation:String,val description:String){

    SMAll("S","Small Size"),
    MEDIUM("M","Medium Size"),
    LARGE(abbreviation = "L", description = "Large Size"),
    XLARGE(abbreviation = "XL", description = "Extra Large Size")

}
enum class Season(val months:List<String>){
    SpringSeason(months = listOf("February","March")),
    SummerSeason(months = listOf("March","April","May","June")),
    MonsoonSeason(months = listOf("July","August","September")),
    AutumnSeason(months = listOf("October","November")),
    WinterSeason(months = listOf("December","January","February"))
}

//Enum Class Properties and Functions
enum class CoffeeType(val displayName: String, val caffeineContent: Double) {
    ESPRESSO("Espresso", 63.0),
    AMERICANO("Americano", 154.0),
    LATTE("Latte", 77.0);

    fun brew(){
        println("Brewing a cup of $displayName")
    }

    fun getCaffeineInfo(): String {
        return "$displayName contains $caffeineContent mg of caffeine"
    }
}
enum class Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
    JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}

fun getDaysInMonth(month: Month): Int {
    return when (month) {
        Month.JANUARY, Month.MARCH, Month.MAY, Month.JULY, Month.AUGUST, Month.OCTOBER, Month.DECEMBER ->
            31
        Month.APRIL, Month.JUNE, Month.SEPTEMBER, Month.NOVEMBER ->
            30
        Month.FEBRUARY ->
            28 // Assuming a non-leap year
    }
}

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

//Implementing interfaces in enum classes
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}

inline fun <reified T : Enum<T>> printAllValues() {
    println(enumValues<T>().joinToString { it.name })
}
fun main() {

    val red =Color.RED
    println("red ${red.rgb}")
    /* Access properties and methods */
    println(CreditCardType.SILVER.color)    // gray
    println(CreditCardType.SILVER.getCashbackValue())   // 0.02

    /* Enum constants are objects of enum class type. */
    val peterCardType: CreditCardType = CreditCardType.GOLD

    /* Each enum object has two properties: ordinal and name */
    println(CreditCardType.GOLD.ordinal)
    println(CreditCardType.GOLD)    // OR CreditCardType.GOLD.name

    /* Each enum object has two methods: values() and valueOf() */
    val myConstants: Array<CreditCardType> = CreditCardType.values()
    myConstants.forEach { println(it) }

    /* Using in 'when' statement */
    when(peterCardType) {
        CreditCardType.SILVER -> println("Peter has silver card")
        CreditCardType.GOLD -> println("Peter has gold card")
        CreditCardType.PLATINUM -> println("Peter has platinum card")
    }


    val tShirtSize = TShirtSize.LARGE
    println("TShirtSize abbreviation  ${tShirtSize.abbreviation}  description  ${tShirtSize.description} ")

    val seasonNow = Season.SummerSeason
    val monthsOfSeason = seasonNow.months
    println("monthsOfSeason  $monthsOfSeason")

    val input = "MonsoonSeason";
    val monthsOfInput = Season.valueOf(input).months;
    println("input: $input, months in $input: $monthsOfInput")

    val americano = CoffeeType.AMERICANO

    americano.brew()
    println(americano.getCaffeineInfo())

    val currentMonth = Month.FEBRUARY
    val daysInMonth = getDaysInMonth(currentMonth)
    println("There are $daysInMonth days in $currentMonth")

    val protocolState =ProtocolState.TALKING.signal()
    println("protocolState $protocolState")

    val intArithmetics =IntArithmetics.PLUS.apply(2,3)
    println("intArithmetics  $intArithmetics")

    printAllValues<Season>() // prints RED, GREEN, BLUE

}
