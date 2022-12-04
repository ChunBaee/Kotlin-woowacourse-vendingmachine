package bridge

import java.util.regex.Pattern

class Regex {

    fun checkVendingHavePrice(userInput : String) : Boolean {
        return try {
            checkIsItNumber(userInput)
            true
        } catch (exception : IllegalArgumentException) {
            false
        }
    }

    private fun checkIsItNumber(userInput : String) {
        if(!Pattern.matches("^[1-9]*$", userInput)) throw IllegalArgumentException()
    }
}