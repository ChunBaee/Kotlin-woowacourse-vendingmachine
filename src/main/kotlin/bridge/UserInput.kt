package bridge

import bridge.Regex
import camp.nextstep.edu.missionutils.Console

class UserInput {
/*
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

    fun inputVendingProducts() : MutableList<String> {
        var input = ""
        var isCorrect = false
        while(!isCorrect) {
            PrintForm().noticeInputProducts()
            input = Console.readLine()
            isCorrect = Regex().checkProduct(input)
        }
        return input.split(";").toMutableList()
    }

    fun inputUserPrice() : Int {
        var input = ""
        var isCorrect = false
        while(!isCorrect) {
            PrintForm().noticeInputUserPrice()
            input = Console.readLine()
            isCorrect = Regex().checkUserInputPrice(input)
        }
        return input.toInt()
    }*/

    fun inputTotalLogic(type : Int) : Any {
        var isCorrect = false
        var result = Pair<Any, Boolean>(0,false)
        while(!isCorrect) {
            result = divideType(type)!!
            isCorrect = result.second
        }
        return result.first
    }

    private fun divideType(type : Int) : Pair<Any, Boolean>?{
        if(type == VENDING_MACHINE_HAVE_MONEY) {
            return vendingMoney()
        }
        if(type == VENDING_PRODUCTS) {
            return vendingProducts()
        }
        if(type == USER_INPUT_PRICE) {
            return userInputPrice()
        }
        return null
    }

    private fun vendingMoney() : Pair<Int, Boolean>{
        PrintForm().noticeInputVendingPrice()
        val input = Console.readLine()
        val isCorrect = Regex().checkVendingHavePrice(input)
        return Pair(input.toInt(), isCorrect)
    }

    private fun vendingProducts() : Pair<MutableList<String>, Boolean>{
        PrintForm().noticeInputProducts()
        val input = Console.readLine()
        val isCorrect = Regex().checkProduct(input)
        return Pair(input.split(";").toMutableList(), isCorrect)
    }

    private fun userInputPrice() : Pair<Int, Boolean> {
        PrintForm().noticeInputUserPrice()
        val input = Console.readLine()
        val isCorrect = Regex().checkUserInputPrice(input)
        return Pair(input.toInt(), isCorrect)
    }

}