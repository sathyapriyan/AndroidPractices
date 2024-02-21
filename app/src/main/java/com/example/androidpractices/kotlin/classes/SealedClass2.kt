package com.example.androidpractices.kotlin.classes

    /*A sealed class is a class that is marked with the sealed keyword in Kotlin.
    It is used to define a closed set of subclasses.
    It allows you to define a restricted class hierarchy in which subclasses are predefined and finite.
    The subclasses of a sealed class are defined within the sealed class itself,
    and each subclass must be declared as inner or data or class, with no other modifiers allowed.*/

    /*Syntax of a Sealed Class:

        sealed class SealedClassName {
            // Subclasses
            class SubclassName1 : SealedClassName()
            class SubclassName2 : SealedClassName()
            // ...
        }

    */
//Representing the Result of an Operation:
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
}
fun handleResult(result: Result) {
    when(result) {
        is Result.Success -> println(result.data)
        is Result.Error -> println(result.message)
    }
}
//State Machine
sealed class State {
    object Initial : State()
    object Running : State()
    object Paused : State()
    object Finished : State()
}
fun handleState(state: State) {
    when(state) {
        is State.Initial -> println("The game is starting...")
        is State.Running -> println("The game is running...")
        is State.Paused -> println("The game is paused...")
        is State.Finished -> println("The game is finished!")
    }
}
//Handling UI States:
sealed class ViewState {
    object Loading : ViewState()
    data class Success(val data: List<String>) : ViewState()
    data class Error(val message: String) : ViewState()
}
fun handleViewState(viewState: ViewState) {
    when(viewState) {
        is ViewState.Loading -> "showLoadingIndicator()"
        is ViewState.Success -> "showData(viewState.data)"
        is ViewState.Error -> "showError(viewState.message)"
    }
}

fun main() {

    val result = Result.Error("Not")
    println(handleResult(result))

    val state = State.Initial
    println(handleState(state))

}

//https://medium.com/@summitkumar/unlocking-the-power-of-sealed-classes-in-kotlin-design-patterns-and-better-code-organization-5627d73a4903#:~:text=A%20common%20use%20case%20for,UI%20states%20of%20a%20screen.