package bridge

import java.util.regex.Pattern

class Regex {

    fun checkVendingHavePrice(userInput : String) : Boolean {
        return try {
            checkIsItNumber(userInput)
            true
        } catch (exception : IllegalArgumentException) {
            PrintForm().noticeErrorMessage(Error.INPUT_INCLUDE_WORDS)
            false
        }
    }

    private fun checkIsItNumber(userInput : String) {
        //!Pattern.matches("^[1-9]*$", userInput)
        if(!userInput.chars().allMatch { Character.isDigit(it)}) throw IllegalArgumentException()
    }
}