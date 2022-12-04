package bridge

import bridge.Regex
import camp.nextstep.edu.missionutils.Console

class UserInput {

    fun inputVendingAlreadyHave() : Int{
        var input = ""
        var isCorrect = false
        while(!isCorrect) {
            PrintForm().noticeInputVendingPrice()
            input = Console.readLine()
            isCorrect = Regex().checkVendingHavePrice(input)
        }
        return input.toInt()
    }
}